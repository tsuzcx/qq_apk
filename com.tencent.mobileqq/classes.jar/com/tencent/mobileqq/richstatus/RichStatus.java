package com.tencent.mobileqq.richstatus;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import bbsy;
import bbsz;
import bbwg;
import bbwi;
import bbwn;
import bhml;
import bizo;
import bjdm;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RichStatus
  implements Serializable, Cloneable
{
  public static final int ACTION_COLOR_NORMAL = -8947849;
  public static final int ACTION_COLOR_PRESSED = -2039584;
  public static final float ACTION_SPAN_RESIZE_FACTOR = 1.1F;
  public static final String EVENT_SPAN_PLACE_HOLDER = "[S]";
  public static final String LOC_SPAN_PLACE_HOLDER = "[L]";
  public static final float LOC_SPAN_RESIZE_FACTOR = 0.9F;
  public static final float OFFSET_IMAGE_SPAN = -0.1F;
  public static final int SPAN_ALIGN_MODE = 0;
  private static RichStatus a;
  public static final ColorStateList sActionColor = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { -2039584, -8947849 });
  private static final long serialVersionUID = 1L;
  public int actId;
  public int actionId = 0;
  public String actionText;
  private String cachedStatusContent;
  private String cachedStatusHeader;
  public int dataId = 0;
  public String dataText;
  public boolean enableSummaryCached;
  public String feedsId;
  public int fontId;
  public int fontType;
  private boolean isEmptyStatus;
  public boolean isFirstReadUins = true;
  public byte[] key;
  public int latitude;
  public int locationPosition;
  public String locationText;
  public int lontitude;
  public ArrayList<RichStatus.StickerInfo> mStickerInfos;
  public List<String> mUins;
  public ArrayList<String> plainText;
  public HashMap<Integer, bbsz> sigZanInfo;
  public int signType;
  public long time;
  public List<Pair<Integer, String>> topics = new ArrayList();
  public List<Pair<Integer, Integer>> topicsPos = new ArrayList();
  public int tplId;
  public int tplType;
  
  public RichStatus(String paramString)
  {
    if (paramString != null)
    {
      this.plainText = new ArrayList();
      this.plainText.add(paramString);
    }
  }
  
  private static int a(String paramString)
  {
    return paramString.getBytes().length;
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramSpannableStringBuilder.append(paramString);
    }
  }
  
  private void a(String paramString)
  {
    if (this.plainText == null) {
      this.plainText = new ArrayList();
    }
    this.plainText.add(paramString);
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramStringBuilder.append(paramString);
    }
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.getBytes();
      paramByteBuffer.put((byte)paramInt).put((byte)paramString.length).put(paramString, 0, paramString.length);
    }
  }
  
  public static RichStatus getEmptyStatus()
  {
    if (a == null) {
      a = new RichStatus(null);
    }
    return a;
  }
  
  public static RichStatus parseStatus(byte[] paramArrayOfByte)
  {
    RichStatus localRichStatus = new RichStatus(null);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 2)) {
      return localRichStatus;
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN);
    Object localObject1 = null;
    int i = 0;
    label118:
    int k;
    int j;
    label150:
    int n;
    Object localObject2;
    for (;;)
    {
      if (localByteBuffer.hasRemaining())
      {
        if (localByteBuffer.remaining() >= 2) {
          break label118;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.status", 2, bhml.a(paramArrayOfByte));
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          localRichStatus.a((String)localObject1);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("RichStatus", 2, String.format("parseStatus %s", new Object[] { localRichStatus.toSpannableString(null) }));
        }
        return localRichStatus;
        k = localByteBuffer.get();
        j = localByteBuffer.get();
        if (k >= 0) {
          break label1174;
        }
        k += 256;
        if (j >= 0) {
          break label1171;
        }
        j += 256;
        if (localByteBuffer.remaining() >= j) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.status", 2, bhml.a(paramArrayOfByte));
        }
      }
      n = i + 2;
      if ((k <= 0) || (k >= 128)) {
        break;
      }
      localObject2 = new String(paramArrayOfByte, n, j);
      i = j + n;
      localByteBuffer.position(i);
      switch (k)
      {
      case 3: 
      default: 
        if (localObject1 == null) {
          localObject1 = localObject2;
        }
        break;
      case 1: 
        localRichStatus.actionText = ((String)localObject2);
        break;
      case 2: 
        localRichStatus.dataText = ((String)localObject2);
        break;
      case 4: 
        if (localObject1 == null) {
          break label1168;
        }
        localRichStatus.a((String)localObject1);
        localObject1 = null;
        label299:
        if (localRichStatus.plainText != null) {}
        for (localRichStatus.locationPosition = localRichStatus.plainText.size();; localRichStatus.locationPosition = 0)
        {
          localRichStatus.locationText = ((String)localObject2);
          break;
        }
        localObject1 = (String)localObject1 + (String)localObject2;
      }
    }
    label464:
    Object localObject4;
    switch (k)
    {
    default: 
    case 129: 
    case 130: 
    case 144: 
    case 145: 
    case 162: 
    case 163: 
    case 146: 
    case 147: 
      for (;;)
      {
        i = n + j;
        localByteBuffer.position(i);
        break;
        if (localByteBuffer.remaining() < 8)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.status", 2, bhml.a(paramArrayOfByte));
          }
        }
        else
        {
          localRichStatus.actionId = localByteBuffer.getInt();
          localRichStatus.dataId = localByteBuffer.getInt();
          continue;
          if (localByteBuffer.remaining() < 8)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.status", 2, bhml.a(paramArrayOfByte));
            }
          }
          else
          {
            localRichStatus.lontitude = localByteBuffer.getInt();
            localRichStatus.latitude = localByteBuffer.getInt();
            continue;
            localRichStatus.feedsId = new String(paramArrayOfByte, n, j);
            if (QLog.isColorLevel())
            {
              QLog.d("Q.richstatus.status", 2, bhml.a(paramArrayOfByte) + ",sign feeds id=" + localRichStatus.feedsId);
              continue;
              localRichStatus.tplId = localByteBuffer.getInt();
              continue;
              localRichStatus.fontId = localByteBuffer.getInt();
              continue;
              localRichStatus.fontType = localByteBuffer.getInt();
              continue;
              localRichStatus.tplType = localByteBuffer.getInt();
              continue;
              localRichStatus.actId = localByteBuffer.getInt();
            }
          }
        }
      }
    case 161: 
      localObject4 = new byte[j];
      localByteBuffer.get((byte[])localObject4);
      localObject2 = new richstatus_sticker.RichStatus_Sticker();
    }
    for (;;)
    {
      try
      {
        ((richstatus_sticker.RichStatus_Sticker)localObject2).mergeFrom((byte[])localObject4);
        if ((!((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.has()) || (((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.size() <= 0)) {
          break label464;
        }
        if (localRichStatus.mStickerInfos == null)
        {
          localRichStatus.mStickerInfos = new ArrayList();
          break label1177;
          if (i >= ((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.size()) {
            break label929;
          }
          localObject4 = (richstatus_sticker.StickerInfo)((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.get(i);
          RichStatus.StickerInfo localStickerInfo = new RichStatus.StickerInfo();
          localStickerInfo.id = ((richstatus_sticker.StickerInfo)localObject4).uint32_id.get();
          localStickerInfo.posX = ((richstatus_sticker.StickerInfo)localObject4).float_posX.get();
          localStickerInfo.posY = ((richstatus_sticker.StickerInfo)localObject4).float_posY.get();
          localStickerInfo.width = ((richstatus_sticker.StickerInfo)localObject4).float_width.get();
          localStickerInfo.height = ((richstatus_sticker.StickerInfo)localObject4).float_height.get();
          localRichStatus.mStickerInfos.add(localStickerInfo);
          i += 1;
          continue;
        }
        localRichStatus.mStickerInfos.clear();
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.e("RichStatus", 1, "parse sticker error: ", localInvalidProtocolBufferMicroException);
      }
      break label464;
      label929:
      if (!QLog.isColorLevel()) {
        break label464;
      }
      QLog.d("RichStatus", 2, "parseStatus sticker info size = " + localRichStatus.mStickerInfos.size());
      break label464;
      if (localByteBuffer.remaining() < 4)
      {
        if (!QLog.isColorLevel()) {
          break label464;
        }
        QLog.d("Q.richstatus.status", 2, bhml.a(paramArrayOfByte));
        break label464;
      }
      i = localByteBuffer.getInt();
      if (j <= 4) {
        break label464;
      }
      Object localObject3 = new String(paramArrayOfByte, n + 4, j - 4);
      if (((String)localObject3).isEmpty()) {
        break label464;
      }
      localObject3 = new Pair(Integer.valueOf(i), localObject3);
      localRichStatus.topics.add(localObject3);
      break label464;
      if (localByteBuffer.remaining() < 5)
      {
        if (!QLog.isColorLevel()) {
          break label464;
        }
        QLog.d("Q.richstatus.status", 2, bhml.a(paramArrayOfByte));
        break label464;
      }
      i = j;
      while (i >= 5)
      {
        int i1 = localByteBuffer.getInt();
        int m = localByteBuffer.get();
        k = m;
        if (m < 0) {
          k = m + 256;
        }
        localObject3 = new Pair(Integer.valueOf(i1), Integer.valueOf(k));
        localRichStatus.topicsPos.add(localObject3);
        i -= 5;
      }
      break label464;
      label1168:
      break label299;
      label1171:
      break label150;
      label1174:
      break;
      label1177:
      i = 0;
    }
  }
  
  public boolean bOnlyHasTopic()
  {
    if (this.topics.size() == 0) {}
    StringBuilder localStringBuilder;
    do
    {
      do
      {
        return false;
      } while (!TextUtils.isEmpty(this.actionText));
      if ((this.plainText == null) || (this.plainText.size() == 0)) {
        return true;
      }
      localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < this.locationPosition)
      {
        a(localStringBuilder, (String)this.plainText.get(i));
        i += 1;
      }
      if (this.plainText != null) {}
      for (i = this.plainText.size();; i = 0)
      {
        int j = this.locationPosition;
        while (j < i)
        {
          a(localStringBuilder, (String)this.plainText.get(j));
          j += 1;
        }
      }
    } while (localStringBuilder.toString().trim().length() != 0);
    return true;
  }
  
  public void clear()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RichStatus", 2, "clear");
    }
    this.tplId = 0;
    this.fontId = 0;
    this.fontType = 0;
    this.actionId = 0;
    this.actionText = null;
    this.dataId = 0;
    this.dataText = "";
    this.mStickerInfos = null;
    this.locationText = "";
  }
  
  public Object clone()
  {
    Object localObject = null;
    try
    {
      RichStatus localRichStatus = (RichStatus)super.clone();
      localObject = localRichStatus;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.plainText != null) {
      localObject.plainText = ((ArrayList)this.plainText.clone());
    }
    if (this.topics.size() > 0)
    {
      localObject.topics.clear();
      localObject.topics.addAll(this.topics);
    }
    if (this.topicsPos.size() > 0)
    {
      localObject.topicsPos.clear();
      localObject.topicsPos.addAll(this.topicsPos);
    }
    return localObject;
  }
  
  public void copyFrom(RichStatus paramRichStatus)
  {
    if (paramRichStatus == null) {
      return;
    }
    this.tplId = paramRichStatus.tplId;
    this.fontId = paramRichStatus.fontId;
    this.fontType = paramRichStatus.fontType;
    this.actionId = paramRichStatus.actionId;
    this.actionText = paramRichStatus.actionText;
    if (paramRichStatus.plainText != null) {}
    for (this.plainText = ((ArrayList)paramRichStatus.plainText.clone());; this.plainText = null)
    {
      this.topics.clear();
      this.topics.addAll(paramRichStatus.topics);
      this.topicsPos.clear();
      this.topicsPos.addAll(paramRichStatus.topicsPos);
      this.locationText = paramRichStatus.locationText;
      return;
    }
  }
  
  public int countLength()
  {
    return (countUtfLength() - 12 + 2) / 3;
  }
  
  public int countUtfLength()
  {
    int k = 0;
    if (!TextUtils.isEmpty(this.actionText)) {}
    for (int j = a(this.actionText) + 12 + 0;; j = 0)
    {
      int i = j;
      if (!TextUtils.isEmpty(this.dataText)) {
        i = j + (a(this.dataText) + 2);
      }
      j = i;
      if (!TextUtils.isEmpty(this.locationText)) {
        j = i + (a(this.locationText) + 12);
      }
      i = 0;
      Object localObject1;
      if (i < this.topics.size())
      {
        localObject1 = (String)((Pair)this.topics.get(i)).second;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (;;)
        {
          i += 1;
          break;
          j += a((String)localObject1) + 6;
        }
      }
      i = j;
      if (this.topicsPos != null)
      {
        i = j;
        if (this.topicsPos.size() > 0) {
          i = j + (this.topicsPos.size() * 5 + 2);
        }
      }
      j = i;
      Object localObject2;
      if (this.plainText != null)
      {
        localObject1 = this.plainText.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            i += a((String)localObject2) + 2;
          }
        }
      }
      j += 24;
      if ((this.mStickerInfos != null) && (this.mStickerInfos.size() > 0))
      {
        localObject1 = new richstatus_sticker.RichStatus_Sticker();
        i = k;
        while (i < this.mStickerInfos.size())
        {
          localObject2 = (RichStatus.StickerInfo)this.mStickerInfos.get(i);
          richstatus_sticker.StickerInfo localStickerInfo = new richstatus_sticker.StickerInfo();
          localStickerInfo.uint32_id.set(((RichStatus.StickerInfo)localObject2).id);
          localStickerInfo.float_posX.set(((RichStatus.StickerInfo)localObject2).posX);
          localStickerInfo.float_posY.set(((RichStatus.StickerInfo)localObject2).posY);
          localStickerInfo.float_width.set(((RichStatus.StickerInfo)localObject2).width);
          localStickerInfo.float_height.set(((RichStatus.StickerInfo)localObject2).height);
          ((richstatus_sticker.RichStatus_Sticker)localObject1).sticker_info.add(localStickerInfo);
          i += 1;
        }
        return ((richstatus_sticker.RichStatus_Sticker)localObject1).toByteArray().length + 2 + j;
      }
      return j;
    }
  }
  
  public byte[] encode()
  {
    int k = 0;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(countUtfLength());
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    a(localByteBuffer, 1, this.actionText);
    a(localByteBuffer, 2, this.dataText);
    int i = 0;
    int j;
    Object localObject;
    int m;
    if (i < this.topics.size())
    {
      j = ((Integer)((Pair)this.topics.get(i)).first).intValue();
      localObject = (String)((Pair)this.topics.get(i)).second;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        i += 1;
        break;
        m = a((String)localObject);
        localObject = ((String)localObject).getBytes();
        localByteBuffer.put((byte)-108).put((byte)(m + 4)).putInt(j).put((byte[])localObject, 0, localObject.length);
      }
    }
    if ((this.topicsPos != null) && (this.topicsPos.size() > 0))
    {
      i = this.topicsPos.size();
      localByteBuffer.put((byte)-107).put((byte)(i * 5));
      i = 0;
      while (i < this.topicsPos.size())
      {
        j = ((Integer)((Pair)this.topicsPos.get(i)).first).intValue();
        m = ((Integer)((Pair)this.topicsPos.get(i)).second).intValue();
        localByteBuffer.putInt(j).put((byte)m);
        i += 1;
      }
    }
    i = 0;
    while (i < this.locationPosition)
    {
      a(localByteBuffer, 3, (String)this.plainText.get(i));
      i += 1;
    }
    a(localByteBuffer, 4, this.locationText);
    if (this.plainText != null) {}
    for (i = this.plainText.size();; i = 0)
    {
      j = this.locationPosition;
      while (j < i)
      {
        a(localByteBuffer, 3, (String)this.plainText.get(j));
        j += 1;
      }
    }
    if (!TextUtils.isEmpty(this.actionText)) {
      localByteBuffer.put((byte)-127).put((byte)8).putInt(this.actionId).putInt(this.dataId);
    }
    if (!TextUtils.isEmpty(this.locationText)) {
      localByteBuffer.put((byte)-126).put((byte)8).putInt(this.lontitude).putInt(this.latitude);
    }
    localByteBuffer.put((byte)-111).put((byte)4).putInt(this.tplId);
    localByteBuffer.put((byte)-110).put((byte)4).putInt(this.tplType);
    localByteBuffer.put((byte)-94).put((byte)4).putInt(this.fontId);
    localByteBuffer.put((byte)-93).put((byte)4).putInt(this.fontType);
    if ((this.mStickerInfos != null) && (this.mStickerInfos.size() > 0))
    {
      localObject = new richstatus_sticker.RichStatus_Sticker();
      i = k;
      while (i < this.mStickerInfos.size())
      {
        RichStatus.StickerInfo localStickerInfo = (RichStatus.StickerInfo)this.mStickerInfos.get(i);
        richstatus_sticker.StickerInfo localStickerInfo1 = new richstatus_sticker.StickerInfo();
        localStickerInfo1.uint32_id.set(localStickerInfo.id);
        localStickerInfo1.float_posX.set(localStickerInfo.posX);
        localStickerInfo1.float_posY.set(localStickerInfo.posY);
        localStickerInfo1.float_width.set(localStickerInfo.width);
        localStickerInfo1.float_height.set(localStickerInfo.height);
        ((richstatus_sticker.RichStatus_Sticker)localObject).sticker_info.add(localStickerInfo1);
        i += 1;
      }
      localObject = ((richstatus_sticker.RichStatus_Sticker)localObject).toByteArray();
      localByteBuffer.put((byte)-95).put((byte)localObject.length).put((byte[])localObject);
      if (QLog.isColorLevel()) {
        QLog.d("RichStatus", 2, "encode sticker info size = " + this.mStickerInfos.size() + " buffer length = " + localObject.length);
      }
    }
    return localByteBuffer.array();
  }
  
  public void ensureContent()
  {
    if (this.plainText == null)
    {
      this.plainText = new ArrayList(2);
      this.plainText.add("");
      this.plainText.add("");
    }
  }
  
  public String getActionAndData()
  {
    Object localObject;
    if ((this.enableSummaryCached) && (this.cachedStatusHeader != null))
    {
      localObject = this.cachedStatusHeader;
      return localObject;
    }
    String str;
    if (TextUtils.isEmpty(this.actionText)) {
      str = "";
    }
    for (;;)
    {
      localObject = str;
      if (!this.enableSummaryCached) {
        break;
      }
      this.cachedStatusHeader = str;
      return str;
      if (TextUtils.isEmpty(this.dataText)) {
        str = this.actionText;
      } else {
        str = this.actionText + this.dataText;
      }
    }
  }
  
  public CharSequence getLocSS(Resources paramResources, float paramFloat, CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(this.locationText)) {}
    for (;;)
    {
      return paramCharSequence;
      Object localObject2 = new StringBuilder();
      Object localObject1;
      if (paramCharSequence != null)
      {
        localObject1 = paramCharSequence;
        localObject1 = new SpannableString(localObject1 + "[L]" + " " + this.locationText);
      }
      try
      {
        localObject2 = BitmapFactory.decodeResource(paramResources, 2130849591);
        if (localObject2 == null) {
          continue;
        }
        int i = (int)(0.9F * paramFloat + 0.5F);
        int j = ((Bitmap)localObject2).getWidth() * i / ((Bitmap)localObject2).getHeight();
        paramResources = new bjdm(paramResources, (Bitmap)localObject2, false, true);
        paramResources.setBounds(0, 0, j, i);
        paramResources = new bizo(paramResources, 0).a(-0.1F);
        if (paramCharSequence == null) {}
        for (i = 0;; i = paramCharSequence.length())
        {
          ((SpannableString)localObject1).setSpan(paramResources, i, "[L]".length() + i, 33);
          return localObject1;
          localObject1 = "";
          break;
        }
        return paramCharSequence;
      }
      catch (OutOfMemoryError paramResources) {}
    }
  }
  
  public CharSequence getLocSS(TextView paramTextView)
  {
    return getLocSS(paramTextView, "");
  }
  
  public CharSequence getLocSS(TextView paramTextView, CharSequence paramCharSequence)
  {
    return getLocSS(paramTextView.getResources(), paramTextView.getTextSize(), paramCharSequence);
  }
  
  public String getPlainText()
  {
    int k = 0;
    if ((this.enableSummaryCached) && (this.cachedStatusContent != null)) {
      return this.cachedStatusContent;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    if (shouldShowAtHead())
    {
      i = 0;
      while (i < this.topics.size())
      {
        localStringBuilder.append((String)((Pair)this.topics.get(i)).second);
        i += 1;
      }
    }
    int i = 0;
    while (i < this.locationPosition)
    {
      a(localStringBuilder, (String)this.plainText.get(i));
      i += 1;
    }
    if (this.plainText != null) {}
    int j;
    for (i = this.plainText.size();; i = 0)
    {
      j = this.locationPosition;
      while (j < i)
      {
        a(localStringBuilder, (String)this.plainText.get(j));
        j += 1;
      }
    }
    String str;
    if (shouldShowMixing())
    {
      sortTopicPos();
      i = k;
      if (i < this.topicsPos.size())
      {
        str = getTopicStrById(((Integer)((Pair)this.topicsPos.get(i)).first).intValue());
        if (!TextUtils.isEmpty(str)) {}
      }
    }
    for (;;)
    {
      i += 1;
      break;
      j = ((Integer)((Pair)this.topicsPos.get(i)).second).intValue();
      if (j > localStringBuilder.length())
      {
        if (this.enableSummaryCached) {
          this.cachedStatusContent = localStringBuilder.toString();
        }
        return localStringBuilder.toString();
      }
      localStringBuilder.insert(j, str);
    }
  }
  
  public String getTopicStrById(int paramInt)
  {
    if ((this.topics == null) || (this.topics.size() <= 0)) {
      return null;
    }
    int i = 0;
    while (i < this.topics.size())
    {
      if (((Integer)((Pair)this.topics.get(i)).first).intValue() == paramInt) {
        return (String)((Pair)this.topics.get(i)).second;
      }
      i += 1;
    }
    return null;
  }
  
  public int getTotalLenForShow()
  {
    CharSequence localCharSequence = toSpannableStringWithoutAction(null);
    int i = 0;
    if (!TextUtils.isEmpty(this.actionText)) {
      i = "[S]".length() + 1;
    }
    return i + localCharSequence.length();
  }
  
  public boolean hasTopic()
  {
    return (this.topics != null) && (this.topics.size() > 0);
  }
  
  public boolean isEmpty()
  {
    int j;
    if (this.plainText != null)
    {
      Iterator localIterator = this.plainText.iterator();
      int i = 1;
      j = i;
      if (!localIterator.hasNext()) {
        break label50;
      }
      if (TextUtils.isEmpty((String)localIterator.next())) {
        break label84;
      }
      i = 0;
    }
    label50:
    label84:
    for (;;)
    {
      break;
      j = 1;
      return (this.actionId == 0) && (this.dataId == 0) && (j != 0) && (this.topics.isEmpty());
    }
  }
  
  public boolean isEmptyStatus()
  {
    return this.isEmptyStatus;
  }
  
  public void setEmptyStatus(boolean paramBoolean)
  {
    this.isEmptyStatus = paramBoolean;
  }
  
  public boolean shouldShowAtHead()
  {
    return (this.topics != null) && (this.topics.size() > 0) && ((this.topicsPos == null) || (this.topicsPos.size() <= 0));
  }
  
  public boolean shouldShowMixing()
  {
    return (this.topics != null) && (this.topics.size() > 0) && (this.topicsPos != null) && (this.topicsPos.size() == this.topics.size());
  }
  
  public void sortTopicPos()
  {
    if ((this.topicsPos != null) && (this.topicsPos.size() > 1)) {
      Collections.sort(this.topicsPos, new bbsy(this));
    }
  }
  
  public SpannableString toSpannableString(String paramString)
  {
    return toSpannableString(paramString, -8947849);
  }
  
  public SpannableString toSpannableString(String paramString, int paramInt)
  {
    return toSpannableString(paramString, paramInt, -2039584);
  }
  
  public SpannableString toSpannableString(String paramString, int paramInt1, int paramInt2)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    paramString = new StringBuilder(str1);
    a(paramString, this.actionText);
    a(paramString, this.dataText);
    paramString = new StringBuilder(paramString.toString().trim());
    int m = paramString.length();
    if (m > str1.length()) {
      paramString.append(' ');
    }
    for (int i = m + 1;; i = m)
    {
      if (shouldShowAtHead())
      {
        j = 0;
        while (j < this.topics.size())
        {
          paramString.append((String)((Pair)this.topics.get(j)).second);
          j += 1;
        }
      }
      int j = 0;
      while (j < this.locationPosition)
      {
        a(paramString, (String)this.plainText.get(j));
        j += 1;
      }
      if (this.plainText != null) {}
      int k;
      for (j = this.plainText.size();; j = 0)
      {
        k = this.locationPosition;
        while (k < j)
        {
          a(paramString, (String)this.plainText.get(k));
          k += 1;
        }
      }
      String str2;
      if (shouldShowMixing())
      {
        sortTopicPos();
        j = 0;
        if (j < this.topicsPos.size())
        {
          str2 = getTopicStrById(((Integer)((Pair)this.topicsPos.get(j)).first).intValue());
          if (!TextUtils.isEmpty(str2)) {}
        }
      }
      for (;;)
      {
        j += 1;
        break;
        k = ((Integer)((Pair)this.topicsPos.get(j)).second).intValue() + i;
        if (k > paramString.length())
        {
          paramString = new SpannableString(paramString.toString().trim());
          if (m > str1.length()) {
            paramString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramInt1, paramInt2), 0, m, 33);
          }
          return paramString;
        }
        paramString.insert(k, str2);
      }
    }
  }
  
  public CharSequence toSpannableStringWithTopic(String paramString, int paramInt1, int paramInt2, bbwi parambbwi)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    paramString = new SpannableStringBuilder(str1);
    a(paramString, this.actionText);
    a(paramString, this.dataText);
    paramString = new SpannableStringBuilder(paramString.toString().trim());
    int m = paramString.length();
    if (m > str1.length()) {
      paramString.append(' ');
    }
    for (int i = m + 1;; i = m)
    {
      int k;
      String str2;
      bbwg localbbwg;
      if (shouldShowAtHead())
      {
        j = 0;
        if (j < this.topics.size())
        {
          if (TextUtils.isEmpty((CharSequence)((Pair)this.topics.get(j)).second)) {}
          for (;;)
          {
            j += 1;
            break;
            k = paramString.length();
            str2 = (String)((Pair)this.topics.get(j)).second;
            localbbwg = new bbwg(parambbwi, bbwn.a(-11692801, -2142399233), new Pair(((Pair)this.topics.get(j)).first, str2));
            paramString.append(str2);
            paramString.setSpan(localbbwg, k, str2.length() + k, 33);
          }
        }
      }
      int j = 0;
      while (j < this.locationPosition)
      {
        a(paramString, (String)this.plainText.get(j));
        j += 1;
      }
      if (this.plainText != null) {}
      for (j = this.plainText.size();; j = 0)
      {
        k = this.locationPosition;
        while (k < j)
        {
          a(paramString, (String)this.plainText.get(k));
          k += 1;
        }
      }
      if (shouldShowMixing())
      {
        sortTopicPos();
        j = 0;
        if (j < this.topicsPos.size())
        {
          str2 = getTopicStrById(((Integer)((Pair)this.topicsPos.get(j)).first).intValue());
          if (!TextUtils.isEmpty(str2)) {}
        }
      }
      for (;;)
      {
        j += 1;
        break;
        k = i + ((Integer)((Pair)this.topicsPos.get(j)).second).intValue();
        if (k > paramString.length())
        {
          if (m > str1.length()) {
            paramString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramInt1, paramInt2), 0, m, 33);
          }
          return paramString;
        }
        localbbwg = new bbwg(parambbwi, bbwn.a(-11692801, -2142399233), new Pair(((Pair)this.topicsPos.get(j)).first, str2));
        paramString.insert(k, str2);
        paramString.setSpan(localbbwg, k, str2.length() + k, 33);
      }
    }
  }
  
  public CharSequence toSpannableStringWithoutAction()
  {
    return toSpannableStringWithoutAction(null);
  }
  
  @NotNull
  public CharSequence toSpannableStringWithoutAction(bbwi parambbwi)
  {
    int k = 0;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int j;
    String str;
    bbwg localbbwg;
    if (shouldShowAtHead())
    {
      i = 0;
      if (i < this.topics.size())
      {
        if (TextUtils.isEmpty((CharSequence)((Pair)this.topics.get(i)).second)) {}
        for (;;)
        {
          i += 1;
          break;
          j = localSpannableStringBuilder.length();
          str = (String)((Pair)this.topics.get(i)).second;
          localbbwg = new bbwg(parambbwi, bbwn.a(-11692801, -2142399233), new Pair(((Pair)this.topics.get(i)).first, str));
          localSpannableStringBuilder.append(str);
          localSpannableStringBuilder.setSpan(localbbwg, j, str.length() + j, 33);
        }
      }
    }
    int i = 0;
    while (i < this.locationPosition)
    {
      a(localSpannableStringBuilder, (String)this.plainText.get(i));
      i += 1;
    }
    if (this.plainText != null) {}
    for (i = this.plainText.size();; i = 0)
    {
      j = this.locationPosition;
      while (j < i)
      {
        a(localSpannableStringBuilder, (String)this.plainText.get(j));
        j += 1;
      }
    }
    if (shouldShowMixing())
    {
      sortTopicPos();
      i = k;
      if (i < this.topicsPos.size())
      {
        str = getTopicStrById(((Integer)((Pair)this.topicsPos.get(i)).first).intValue());
        if (!TextUtils.isEmpty(str)) {}
      }
    }
    for (;;)
    {
      i += 1;
      break;
      j = ((Integer)((Pair)this.topicsPos.get(i)).second).intValue();
      if (j > localSpannableStringBuilder.length()) {
        return localSpannableStringBuilder;
      }
      localbbwg = new bbwg(parambbwi, bbwn.a(-11692801, -2142399233), new Pair(((Pair)this.topicsPos.get(i)).first, str));
      localSpannableStringBuilder.insert(j, str);
      localSpannableStringBuilder.setSpan(localbbwg, j, str.length() + j, 33);
    }
  }
  
  /* Error */
  public void topicFromJson(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 104	com/tencent/mobileqq/richstatus/RichStatus:topics	Ljava/util/List;
    //   4: invokeinterface 388 1 0
    //   9: aload_1
    //   10: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +132 -> 145
    //   16: new 633	org/json/JSONArray
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 634	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   24: astore 4
    //   26: iconst_0
    //   27: istore_2
    //   28: iload_2
    //   29: aload 4
    //   31: invokevirtual 635	org/json/JSONArray:length	()I
    //   34: if_icmpge +111 -> 145
    //   37: aload 4
    //   39: iload_2
    //   40: invokevirtual 636	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   43: checkcast 638	org/json/JSONObject
    //   46: astore 5
    //   48: aload 5
    //   50: ldc_w 639
    //   53: invokevirtual 642	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   56: istore_3
    //   57: aload 5
    //   59: ldc_w 644
    //   62: invokevirtual 648	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 5
    //   67: aload 5
    //   69: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifne +26 -> 98
    //   75: aload_0
    //   76: getfield 104	com/tencent/mobileqq/richstatus/RichStatus:topics	Ljava/util/List;
    //   79: new 352	com/tencent/util/Pair
    //   82: dup
    //   83: iload_3
    //   84: invokestatic 358	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aload 5
    //   89: invokespecial 361	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   92: invokeinterface 364 2 0
    //   97: pop
    //   98: iload_2
    //   99: iconst_1
    //   100: iadd
    //   101: istore_2
    //   102: goto -74 -> 28
    //   105: astore 4
    //   107: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +35 -> 145
    //   113: ldc 203
    //   115: iconst_2
    //   116: new 135	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   123: ldc_w 649
    //   126: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 4
    //   131: invokevirtual 652	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: aload 4
    //   142: invokestatic 654	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +23 -> 171
    //   151: ldc 203
    //   153: iconst_2
    //   154: ldc_w 656
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_1
    //   164: aastore
    //   165: invokestatic 213	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   168: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: return
    //   172: astore 4
    //   174: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq -32 -> 145
    //   180: ldc 203
    //   182: iconst_2
    //   183: new 135	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 649
    //   193: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 4
    //   198: invokevirtual 657	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   201: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: aload 4
    //   209: invokestatic 654	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   212: goto -67 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	RichStatus
    //   0	215	1	paramString	String
    //   27	75	2	i	int
    //   56	28	3	j	int
    //   24	14	4	localJSONArray	JSONArray
    //   105	36	4	localJSONException	JSONException
    //   172	36	4	localException	java.lang.Exception
    //   46	42	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	26	105	org/json/JSONException
    //   28	98	105	org/json/JSONException
    //   16	26	172	java/lang/Exception
    //   28	98	172	java/lang/Exception
  }
  
  /* Error */
  public void topicPosFromJson(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 106	com/tencent/mobileqq/richstatus/RichStatus:topicsPos	Ljava/util/List;
    //   4: invokeinterface 388 1 0
    //   9: aload_1
    //   10: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +127 -> 140
    //   16: new 633	org/json/JSONArray
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 634	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   24: astore 5
    //   26: iconst_0
    //   27: istore_2
    //   28: iload_2
    //   29: aload 5
    //   31: invokevirtual 635	org/json/JSONArray:length	()I
    //   34: if_icmpge +106 -> 140
    //   37: aload 5
    //   39: iload_2
    //   40: invokevirtual 636	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   43: checkcast 638	org/json/JSONObject
    //   46: astore 6
    //   48: aload 6
    //   50: ldc_w 639
    //   53: invokevirtual 642	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   56: istore_3
    //   57: aload 6
    //   59: ldc_w 660
    //   62: invokevirtual 642	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   65: istore 4
    //   67: aload_0
    //   68: getfield 106	com/tencent/mobileqq/richstatus/RichStatus:topicsPos	Ljava/util/List;
    //   71: new 352	com/tencent/util/Pair
    //   74: dup
    //   75: iload_3
    //   76: invokestatic 358	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: iload 4
    //   81: invokestatic 358	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: invokespecial 361	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   87: invokeinterface 364 2 0
    //   92: pop
    //   93: iload_2
    //   94: iconst_1
    //   95: iadd
    //   96: istore_2
    //   97: goto -69 -> 28
    //   100: astore 5
    //   102: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +35 -> 140
    //   108: ldc 203
    //   110: iconst_2
    //   111: new 135	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 661
    //   121: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 5
    //   126: invokevirtual 652	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: aload 5
    //   137: invokestatic 654	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +23 -> 166
    //   146: ldc 203
    //   148: iconst_2
    //   149: ldc_w 663
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_1
    //   159: aastore
    //   160: invokestatic 213	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: return
    //   167: astore 5
    //   169: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq -32 -> 140
    //   175: ldc 203
    //   177: iconst_2
    //   178: new 135	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 661
    //   188: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload 5
    //   193: invokevirtual 657	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   196: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: aload 5
    //   204: invokestatic 654	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   207: goto -67 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	RichStatus
    //   0	210	1	paramString	String
    //   27	70	2	i	int
    //   56	20	3	j	int
    //   65	15	4	k	int
    //   24	14	5	localJSONArray	JSONArray
    //   100	36	5	localJSONException	JSONException
    //   167	36	5	localException	java.lang.Exception
    //   46	12	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   16	26	100	org/json/JSONException
    //   28	93	100	org/json/JSONException
    //   16	26	167	java/lang/Exception
    //   28	93	167	java/lang/Exception
  }
  
  public String topicPosToJson()
  {
    int i = 0;
    localObject = null;
    if (i < this.topicsPos.size())
    {
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        for (;;)
        {
          try
          {
            localJSONObject.put("id", ((Pair)this.topicsPos.get(i)).first);
            localJSONObject.put("topicPos", ((Pair)this.topicsPos.get(i)).second);
            if (localObject != null) {
              continue;
            }
            JSONArray localJSONArray = new JSONArray();
            localObject = localJSONArray;
          }
          catch (JSONException localJSONException2)
          {
            continue;
            localObject = "";
            continue;
            continue;
          }
          try
          {
            ((JSONArray)localObject).put(localJSONObject);
            i += 1;
          }
          catch (JSONException localJSONException1) {}
        }
        localJSONException1.printStackTrace();
      }
    }
    if (localObject != null)
    {
      localObject = ((JSONArray)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.i("RichStatus", 2, String.format("topicPosToJson %s", new Object[] { localObject }));
      }
      return localObject;
    }
  }
  
  public String topicToJson()
  {
    localObject = null;
    int i = 0;
    if (i < this.topics.size())
    {
      if (TextUtils.isEmpty((CharSequence)((Pair)this.topics.get(i)).second)) {}
      for (;;)
      {
        i += 1;
        break;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("id", ((Pair)this.topics.get(i)).first);
          localJSONObject.put("topic", ((Pair)this.topics.get(i)).second);
          if (localObject != null) {
            break label188;
          }
          JSONArray localJSONArray = new JSONArray();
          localObject = localJSONArray;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            continue;
            localObject = "";
          }
        }
        try
        {
          ((JSONArray)localObject).put(localJSONObject);
        }
        catch (JSONException localJSONException1) {}
        localJSONException1.printStackTrace();
      }
    }
    if (localObject != null)
    {
      localObject = ((JSONArray)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.i("RichStatus", 2, String.format("topicToJson %s", new Object[] { localObject }));
      }
      return localObject;
    }
  }
  
  public String topicToPlainText()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < this.topics.size())
    {
      if (TextUtils.isEmpty((CharSequence)((Pair)this.topics.get(i)).second)) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append((String)((Pair)this.topics.get(i)).second);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("RichStatus", 2, String.format("topicToPlainText %s", new Object[] { localStringBuilder.toString() }));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatus
 * JD-Core Version:    0.7.0.1
 */