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
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richstatus.topic.ClickColorTopicSpan;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
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
  public static final int TOPIC_COLOR = -11692801;
  public static final int TOPIC_COLOR_PRESSED = -2142399233;
  private static RichStatus a;
  public static final ColorStateList sActionColor = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { -2039584, -8947849 });
  private static final long serialVersionUID = 1L;
  public int actId;
  public int actionId = 0;
  public String actionText;
  private String cachedStatusContent = null;
  private String cachedStatusHeader = null;
  public int dataId = 0;
  public String dataText;
  public boolean enableSummaryCached = false;
  public String feedsId;
  public int fontId;
  public int fontType;
  private boolean isEmptyStatus = false;
  public boolean isFirstReadUins = true;
  public byte[] key;
  public int latitude;
  public int locationPosition;
  public String locationText;
  public int lontitude;
  public ArrayList<RichStatus.StickerInfo> mStickerInfos;
  public List<String> mUins;
  public ArrayList<String> plainText;
  public HashMap<Integer, RichStatus.SigZanInfo> sigZanInfo;
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
  
  private ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { { 16842919 }, { 0 } }, new int[] { paramInt2, paramInt1 });
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
  
  private static int b(String paramString)
  {
    return paramString.getBytes().length;
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
    ByteBuffer localByteBuffer;
    Object localObject1;
    int j;
    int i;
    int m;
    int k;
    int n;
    Object localObject4;
    Object localObject2;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 2) {
        return localRichStatus;
      }
      localByteBuffer = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN);
      localObject1 = null;
      j = 0;
      for (;;)
      {
        if (localByteBuffer.hasRemaining()) {
          if (localByteBuffer.remaining() < 2)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(paramArrayOfByte));
            }
          }
          else
          {
            i = localByteBuffer.get();
            m = localByteBuffer.get();
            k = i;
            if (i < 0) {
              k = i + 256;
            }
            i = m;
            if (m < 0) {
              i = m + 256;
            }
            if (localByteBuffer.remaining() < i)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(paramArrayOfByte));
              }
            }
            else
            {
              n = j + 2;
              if ((k > 0) && (k < 128))
              {
                localObject4 = new String(paramArrayOfByte, n, i);
                j = n + i;
                localByteBuffer.position(j);
                if (k != 1)
                {
                  if (k != 2)
                  {
                    if (k != 4)
                    {
                      if (localObject1 == null)
                      {
                        localObject1 = localObject4;
                      }
                      else
                      {
                        localObject2 = new StringBuilder();
                        ((StringBuilder)localObject2).append((String)localObject1);
                        ((StringBuilder)localObject2).append((String)localObject4);
                        localObject1 = ((StringBuilder)localObject2).toString();
                      }
                    }
                    else
                    {
                      localObject2 = localObject1;
                      if (localObject1 != null)
                      {
                        localRichStatus.a((String)localObject1);
                        localObject2 = null;
                      }
                      localObject1 = localRichStatus.plainText;
                      if (localObject1 != null) {
                        localRichStatus.locationPosition = ((ArrayList)localObject1).size();
                      } else {
                        localRichStatus.locationPosition = 0;
                      }
                      localRichStatus.locationText = ((String)localObject4);
                      localObject1 = localObject2;
                    }
                  }
                  else {
                    localRichStatus.dataText = ((String)localObject4);
                  }
                }
                else {
                  localRichStatus.actionText = ((String)localObject4);
                }
              }
              else if (k != 129)
              {
                if (k != 130) {
                  switch (k)
                  {
                  default: 
                    switch (k)
                    {
                    default: 
                      break;
                    case 163: 
                      localRichStatus.fontType = localByteBuffer.getInt();
                      break;
                    case 162: 
                      localRichStatus.fontId = localByteBuffer.getInt();
                      break;
                    case 161: 
                      localObject4 = new byte[i];
                      localByteBuffer.get((byte[])localObject4);
                      localObject2 = new richstatus_sticker.RichStatus_Sticker();
                    }
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        ((richstatus_sticker.RichStatus_Sticker)localObject2).mergeFrom((byte[])localObject4);
        if ((!((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.has()) || (((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.size() <= 0)) {
          break label1137;
        }
        if (localRichStatus.mStickerInfos == null) {
          localRichStatus.mStickerInfos = new ArrayList();
        } else {
          localRichStatus.mStickerInfos.clear();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        RichStatus.StickerInfo localStickerInfo;
        QLog.e("RichStatus", 1, "parse sticker error: ", localInvalidProtocolBufferMicroException);
        break label1137;
      }
      if (j < ((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.size())
      {
        localObject4 = (richstatus_sticker.StickerInfo)((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.get(j);
        localStickerInfo = new RichStatus.StickerInfo();
        localStickerInfo.id = ((richstatus_sticker.StickerInfo)localObject4).uint32_id.get();
        localStickerInfo.posX = ((richstatus_sticker.StickerInfo)localObject4).float_posX.get();
        localStickerInfo.posY = ((richstatus_sticker.StickerInfo)localObject4).float_posY.get();
        localStickerInfo.width = ((richstatus_sticker.StickerInfo)localObject4).float_width.get();
        localStickerInfo.height = ((richstatus_sticker.StickerInfo)localObject4).float_height.get();
        localRichStatus.mStickerInfos.add(localStickerInfo);
        j += 1;
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parseStatus sticker info size = ");
          ((StringBuilder)localObject2).append(localRichStatus.mStickerInfos.size());
          QLog.d("RichStatus", 2, ((StringBuilder)localObject2).toString());
          break label1137;
          if (localByteBuffer.remaining() < 5)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(paramArrayOfByte));
            }
            QLog.e("RichStatus", 1, "parseStatus error, T_TOPIC_POS remaining not enough!");
          }
          else
          {
            j = i;
            while (j >= 5)
            {
              int i1 = localByteBuffer.getInt();
              m = localByteBuffer.get();
              k = m;
              if (m < 0) {
                k = m + 256;
              }
              Object localObject3 = new Pair(Integer.valueOf(i1), Integer.valueOf(k));
              localRichStatus.topicsPos.add(localObject3);
              j -= 5;
              continue;
              if (localByteBuffer.remaining() < 4)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(paramArrayOfByte));
                }
              }
              else
              {
                j = localByteBuffer.getInt();
                if (i > 4)
                {
                  localObject3 = new String(paramArrayOfByte, n + 4, i - 4);
                  if (!((String)localObject3).isEmpty())
                  {
                    localObject3 = new Pair(Integer.valueOf(j), localObject3);
                    localRichStatus.topics.add(localObject3);
                    break;
                    localRichStatus.actId = localByteBuffer.getInt();
                    break;
                    localRichStatus.tplType = localByteBuffer.getInt();
                    break;
                    localRichStatus.tplId = localByteBuffer.getInt();
                    break;
                    localRichStatus.feedsId = new String(paramArrayOfByte, n, i);
                    if (QLog.isColorLevel())
                    {
                      localObject3 = new StringBuilder();
                      ((StringBuilder)localObject3).append(HexUtil.bytes2HexStr(paramArrayOfByte));
                      ((StringBuilder)localObject3).append(",sign feeds id=");
                      ((StringBuilder)localObject3).append(localRichStatus.feedsId);
                      QLog.d("Q.richstatus.status", 2, ((StringBuilder)localObject3).toString());
                      break;
                      if (localByteBuffer.remaining() < 8)
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(paramArrayOfByte));
                        }
                      }
                      else
                      {
                        localRichStatus.lontitude = localByteBuffer.getInt();
                        localRichStatus.latitude = localByteBuffer.getInt();
                        break;
                        if (localByteBuffer.remaining() < 8)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.richstatus.status", 2, HexUtil.bytes2HexStr(paramArrayOfByte));
                          }
                        }
                        else
                        {
                          localRichStatus.actionId = localByteBuffer.getInt();
                          localRichStatus.dataId = localByteBuffer.getInt();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label1137:
        j = n + i;
        localByteBuffer.position(j);
        break;
        if (localObject1 != null) {
          localRichStatus.a((String)localObject1);
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("RichStatus", 2, String.format("parseStatus %s", new Object[] { localRichStatus.toSpannableString(null) }));
        }
        return localRichStatus;
        j = 0;
      }
    }
  }
  
  public boolean bOnlyHasTopic()
  {
    int i = this.topics.size();
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    if (!TextUtils.isEmpty(this.actionText)) {
      return false;
    }
    Object localObject = this.plainText;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
        return true;
      }
      localObject = new StringBuilder();
      i = 0;
      while (i < this.locationPosition)
      {
        a((StringBuilder)localObject, (String)this.plainText.get(i));
        i += 1;
      }
      ArrayList localArrayList = this.plainText;
      if (localArrayList != null) {
        i = localArrayList.size();
      } else {
        i = 0;
      }
      int j = this.locationPosition;
      while (j < i)
      {
        a((StringBuilder)localObject, (String)this.plainText.get(j));
        j += 1;
      }
      if (((StringBuilder)localObject).toString().trim().length() == 0) {
        bool = true;
      }
      return bool;
    }
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
    Object localObject;
    try
    {
      RichStatus localRichStatus = (RichStatus)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
      localObject = null;
    }
    ArrayList localArrayList = this.plainText;
    if (localArrayList != null) {
      localObject.plainText = ((ArrayList)localArrayList.clone());
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
    ArrayList localArrayList = paramRichStatus.plainText;
    if (localArrayList != null) {
      this.plainText = ((ArrayList)localArrayList.clone());
    } else {
      this.plainText = null;
    }
    this.topics.clear();
    this.topics.addAll(paramRichStatus.topics);
    this.topicsPos.clear();
    this.topicsPos.addAll(paramRichStatus.topicsPos);
    this.locationText = paramRichStatus.locationText;
  }
  
  public int countLength()
  {
    return (countUtfLength() - 12 + 2) / 3;
  }
  
  public int countUtfLength()
  {
    boolean bool = TextUtils.isEmpty(this.actionText);
    int k = 0;
    if (!bool) {
      j = b(this.actionText) + 12 + 0;
    } else {
      j = 0;
    }
    int i = j;
    if (!TextUtils.isEmpty(this.dataText)) {
      i = j + (b(this.dataText) + 2);
    }
    int j = i;
    if (!TextUtils.isEmpty(this.locationText)) {
      j = i + (b(this.locationText) + 12);
    }
    i = 0;
    while (i < this.topics.size())
    {
      localObject1 = (String)((Pair)this.topics.get(i)).second;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        j += b((String)localObject1) + 6;
      }
      i += 1;
    }
    Object localObject1 = this.topicsPos;
    i = j;
    if (localObject1 != null)
    {
      i = j;
      if (((List)localObject1).size() > 0) {
        i = j + (this.topicsPos.size() * 5 + 2);
      }
    }
    localObject1 = this.plainText;
    j = i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          i += b((String)localObject2) + 2;
        }
      }
    }
    j += 24;
    localObject1 = this.mStickerInfos;
    i = j;
    if (localObject1 != null)
    {
      i = j;
      if (((ArrayList)localObject1).size() > 0)
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
        i = j + (((richstatus_sticker.RichStatus_Sticker)localObject1).toByteArray().length + 2);
      }
    }
    return i;
  }
  
  public byte[] encode()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(countUtfLength());
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    a(localByteBuffer, 1, this.actionText);
    a(localByteBuffer, 2, this.dataText);
    int k = 0;
    int i = 0;
    int m;
    while (i < this.topics.size())
    {
      j = ((Integer)((Pair)this.topics.get(i)).first).intValue();
      localObject1 = (String)((Pair)this.topics.get(i)).second;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        m = b((String)localObject1);
        localObject1 = ((String)localObject1).getBytes();
        localByteBuffer.put((byte)-108).put((byte)(m + 4)).putInt(j).put((byte[])localObject1, 0, localObject1.length);
      }
      i += 1;
    }
    Object localObject1 = this.topicsPos;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
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
    if (this.plainText != null)
    {
      i = 0;
      while (i < this.locationPosition)
      {
        a(localByteBuffer, 3, (String)this.plainText.get(i));
        i += 1;
      }
    }
    a(localByteBuffer, 4, this.locationText);
    localObject1 = this.plainText;
    if (localObject1 != null) {
      i = ((ArrayList)localObject1).size();
    } else {
      i = 0;
    }
    int j = this.locationPosition;
    while (j < i)
    {
      a(localByteBuffer, 3, (String)this.plainText.get(j));
      j += 1;
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
    localObject1 = this.mStickerInfos;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = new richstatus_sticker.RichStatus_Sticker();
      i = k;
      Object localObject2;
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
      localObject1 = ((richstatus_sticker.RichStatus_Sticker)localObject1).toByteArray();
      localByteBuffer.put((byte)-95).put((byte)localObject1.length).put((byte[])localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("encode sticker info size = ");
        ((StringBuilder)localObject2).append(this.mStickerInfos.size());
        ((StringBuilder)localObject2).append(" buffer length = ");
        ((StringBuilder)localObject2).append(localObject1.length);
        QLog.d("RichStatus", 2, ((StringBuilder)localObject2).toString());
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
    if (this.enableSummaryCached)
    {
      localObject = this.cachedStatusHeader;
      if (localObject != null) {
        return localObject;
      }
    }
    if (TextUtils.isEmpty(this.actionText))
    {
      localObject = "";
    }
    else if (TextUtils.isEmpty(this.dataText))
    {
      localObject = this.actionText;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.actionText);
      ((StringBuilder)localObject).append(this.dataText);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (this.enableSummaryCached) {
      this.cachedStatusHeader = ((String)localObject);
    }
    return localObject;
  }
  
  public CharSequence getLocSS(Resources paramResources, float paramFloat, CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(this.locationText)) {
      return paramCharSequence;
    }
    Object localObject2 = new StringBuilder();
    if (paramCharSequence != null) {
      localObject1 = paramCharSequence;
    } else {
      localObject1 = "";
    }
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append("[L]");
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(this.locationText);
    Object localObject1 = new SpannableString(((StringBuilder)localObject2).toString());
    try
    {
      localObject2 = BitmapFactory.decodeResource(paramResources, 2130851614);
      if (localObject2 == null) {
        return paramCharSequence;
      }
      int j = (int)(paramFloat * 0.9F + 0.5F);
      int k = ((Bitmap)localObject2).getWidth() * j / ((Bitmap)localObject2).getHeight();
      int i = 0;
      paramResources = new StatableBitmapDrawable(paramResources, (Bitmap)localObject2, false, true);
      paramResources.setBounds(0, 0, k, j);
      paramResources = new OffsetableImageSpan(paramResources, 0).setOffset(-0.1F);
      if (paramCharSequence != null) {
        i = paramCharSequence.length();
      }
      ((SpannableString)localObject1).setSpan(paramResources, i, i + 3, 33);
      return localObject1;
    }
    catch (OutOfMemoryError paramResources) {}
    return paramCharSequence;
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
    if (this.enableSummaryCached)
    {
      localObject1 = this.cachedStatusContent;
      if (localObject1 != null) {
        return localObject1;
      }
    }
    Object localObject1 = new StringBuilder(100);
    boolean bool = shouldShowAtHead();
    int k = 0;
    int i;
    if (bool)
    {
      i = 0;
      while (i < this.topics.size())
      {
        ((StringBuilder)localObject1).append((String)((Pair)this.topics.get(i)).second);
        i += 1;
      }
    }
    if (this.plainText != null)
    {
      i = 0;
      while (i < this.locationPosition)
      {
        a((StringBuilder)localObject1, (String)this.plainText.get(i));
        i += 1;
      }
    }
    Object localObject2 = this.plainText;
    if (localObject2 != null) {
      i = ((ArrayList)localObject2).size();
    } else {
      i = 0;
    }
    int j = this.locationPosition;
    while (j < i)
    {
      a((StringBuilder)localObject1, (String)this.plainText.get(j));
      j += 1;
    }
    if (shouldShowMixing())
    {
      sortTopicPos();
      i = k;
      while (i < this.topicsPos.size())
      {
        localObject2 = getTopicStrById(((Integer)((Pair)this.topicsPos.get(i)).first).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          j = ((Integer)((Pair)this.topicsPos.get(i)).second).intValue();
          if (j > ((StringBuilder)localObject1).length()) {
            break;
          }
          ((StringBuilder)localObject1).insert(j, (String)localObject2);
        }
        i += 1;
      }
    }
    if (this.enableSummaryCached) {
      this.cachedStatusContent = ((StringBuilder)localObject1).toString();
    }
    return ((StringBuilder)localObject1).toString();
  }
  
  public String getTopicStrById(int paramInt)
  {
    List localList = this.topics;
    if (localList != null)
    {
      if (localList.size() <= 0) {
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
    }
    return null;
  }
  
  public int getTotalLenForShow()
  {
    CharSequence localCharSequence = toSpannableStringWithoutAction(null);
    int i;
    if (!TextUtils.isEmpty(this.actionText)) {
      i = 4;
    } else {
      i = 0;
    }
    return i + localCharSequence.length();
  }
  
  public boolean hasTopic()
  {
    List localList = this.topics;
    return (localList != null) && (localList.size() > 0);
  }
  
  public boolean isEmpty()
  {
    Object localObject = this.plainText;
    boolean bool2 = false;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      int i = 1;
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        if (!TextUtils.isEmpty((String)((Iterator)localObject).next())) {
          i = 0;
        }
      }
    }
    int j = 1;
    boolean bool1 = bool2;
    if (this.actionId == 0)
    {
      bool1 = bool2;
      if (this.dataId == 0)
      {
        bool1 = bool2;
        if (j != 0)
        {
          bool1 = bool2;
          if (this.topics.isEmpty()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
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
    List localList = this.topics;
    if ((localList != null) && (localList.size() > 0))
    {
      localList = this.topicsPos;
      if ((localList == null) || (localList.size() <= 0)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean shouldShowMixing()
  {
    List localList = this.topics;
    if ((localList != null) && (localList.size() > 0))
    {
      localList = this.topicsPos;
      if ((localList != null) && (localList.size() == this.topics.size())) {
        return true;
      }
    }
    return false;
  }
  
  public void sortTopicPos()
  {
    List localList = this.topicsPos;
    if ((localList != null) && (localList.size() > 1)) {
      Collections.sort(this.topicsPos, new RichStatus.1(this));
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
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder(str);
    a(paramString, this.actionText);
    a(paramString, this.dataText);
    paramString = new StringBuilder(paramString.toString().trim());
    int m = paramString.length();
    int i;
    if (m > str.length())
    {
      paramString.append(' ');
      i = m + 1;
    }
    else
    {
      i = m;
    }
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
    Object localObject = this.plainText;
    if (localObject != null) {
      j = ((ArrayList)localObject).size();
    } else {
      j = 0;
    }
    int k = this.locationPosition;
    while (k < j)
    {
      a(paramString, (String)this.plainText.get(k));
      k += 1;
    }
    if (shouldShowMixing())
    {
      sortTopicPos();
      j = 0;
      while (j < this.topicsPos.size())
      {
        localObject = getTopicStrById(((Integer)((Pair)this.topicsPos.get(j)).first).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          k = ((Integer)((Pair)this.topicsPos.get(j)).second).intValue() + i;
          if (k > paramString.length()) {
            break;
          }
          paramString.insert(k, (String)localObject);
        }
        j += 1;
      }
    }
    paramString = new SpannableString(paramString.toString().trim());
    if (m > str.length()) {
      paramString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramInt1, paramInt2), 0, m, 33);
    }
    return paramString;
  }
  
  public CharSequence toSpannableStringWithTopic(String paramString, int paramInt1, int paramInt2, ITopic.OnTopicClickListener paramOnTopicClickListener)
  {
    if (paramString == null) {
      paramString = "";
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    a(localSpannableStringBuilder, this.actionText);
    a(localSpannableStringBuilder, this.dataText);
    localSpannableStringBuilder = new SpannableStringBuilder(localSpannableStringBuilder.toString().trim());
    int m = localSpannableStringBuilder.length();
    int i;
    if (m > paramString.length())
    {
      localSpannableStringBuilder.append(' ');
      i = m + 1;
    }
    else
    {
      i = m;
    }
    int j;
    ClickColorTopicSpan localClickColorTopicSpan;
    if (shouldShowAtHead())
    {
      j = 0;
      while (j < this.topics.size())
      {
        if (!TextUtils.isEmpty((CharSequence)((Pair)this.topics.get(j)).second))
        {
          k = localSpannableStringBuilder.length();
          localObject = (String)((Pair)this.topics.get(j)).second;
          localClickColorTopicSpan = new ClickColorTopicSpan(paramOnTopicClickListener, a(-11692801, -2142399233), new Pair(((Pair)this.topics.get(j)).first, localObject));
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(localClickColorTopicSpan, k, ((String)localObject).length() + k, 33);
        }
        j += 1;
      }
    }
    if (this.plainText != null)
    {
      j = 0;
      while (j < this.locationPosition)
      {
        a(localSpannableStringBuilder, (String)this.plainText.get(j));
        j += 1;
      }
    }
    Object localObject = this.plainText;
    if (localObject != null) {
      j = ((ArrayList)localObject).size();
    } else {
      j = 0;
    }
    int k = this.locationPosition;
    while (k < j)
    {
      a(localSpannableStringBuilder, (String)this.plainText.get(k));
      k += 1;
    }
    if (shouldShowMixing())
    {
      sortTopicPos();
      j = 0;
      while (j < this.topicsPos.size())
      {
        localObject = getTopicStrById(((Integer)((Pair)this.topicsPos.get(j)).first).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          k = ((Integer)((Pair)this.topicsPos.get(j)).second).intValue() + i;
          if (k > localSpannableStringBuilder.length()) {
            break;
          }
          localClickColorTopicSpan = new ClickColorTopicSpan(paramOnTopicClickListener, a(-11692801, -2142399233), new Pair(((Pair)this.topicsPos.get(j)).first, localObject));
          localSpannableStringBuilder.insert(k, (CharSequence)localObject);
          localSpannableStringBuilder.setSpan(localClickColorTopicSpan, k, ((String)localObject).length() + k, 33);
        }
        j += 1;
      }
    }
    if (m > paramString.length()) {
      localSpannableStringBuilder.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramInt1, paramInt2), 0, m, 33);
    }
    return localSpannableStringBuilder;
  }
  
  public CharSequence toSpannableStringWithoutAction()
  {
    return toSpannableStringWithoutAction(null);
  }
  
  @NonNull
  public CharSequence toSpannableStringWithoutAction(ITopic.OnTopicClickListener paramOnTopicClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    boolean bool = shouldShowAtHead();
    int k = 0;
    ClickColorTopicSpan localClickColorTopicSpan;
    if (bool)
    {
      i = 0;
      while (i < this.topics.size())
      {
        if (!TextUtils.isEmpty((CharSequence)((Pair)this.topics.get(i)).second))
        {
          j = localSpannableStringBuilder.length();
          localObject = (String)((Pair)this.topics.get(i)).second;
          localClickColorTopicSpan = new ClickColorTopicSpan(paramOnTopicClickListener, a(-11692801, -2142399233), new Pair(((Pair)this.topics.get(i)).first, localObject));
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.setSpan(localClickColorTopicSpan, j, ((String)localObject).length() + j, 33);
        }
        i += 1;
      }
    }
    int i = 0;
    while (i < this.locationPosition)
    {
      a(localSpannableStringBuilder, (String)this.plainText.get(i));
      i += 1;
    }
    Object localObject = this.plainText;
    if (localObject != null) {
      i = ((ArrayList)localObject).size();
    } else {
      i = 0;
    }
    int j = this.locationPosition;
    while (j < i)
    {
      a(localSpannableStringBuilder, (String)this.plainText.get(j));
      j += 1;
    }
    if (shouldShowMixing())
    {
      sortTopicPos();
      i = k;
      while (i < this.topicsPos.size())
      {
        localObject = getTopicStrById(((Integer)((Pair)this.topicsPos.get(i)).first).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          j = ((Integer)((Pair)this.topicsPos.get(i)).second).intValue();
          if (j > localSpannableStringBuilder.length()) {
            return localSpannableStringBuilder;
          }
          localClickColorTopicSpan = new ClickColorTopicSpan(paramOnTopicClickListener, a(-11692801, -2142399233), new Pair(((Pair)this.topicsPos.get(i)).first, localObject));
          localSpannableStringBuilder.insert(j, (CharSequence)localObject);
          localSpannableStringBuilder.setSpan(localClickColorTopicSpan, j, ((String)localObject).length() + j, 33);
        }
        i += 1;
      }
    }
    return localSpannableStringBuilder;
  }
  
  public void topicFromJson(String paramString)
  {
    this.topics.clear();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        int i = 0;
        Object localObject;
        while (i < localJSONArray.length())
        {
          localObject = (JSONObject)localJSONArray.get(i);
          int j = ((JSONObject)localObject).optInt("id");
          localObject = ((JSONObject)localObject).optString("topic");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.topics.add(new Pair(Integer.valueOf(j), localObject));
          }
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("topicFromJson");
          ((StringBuilder)localObject).append(localException.getMessage());
          QLog.i("RichStatus", 2, ((StringBuilder)localObject).toString(), localException);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("topicFromJson");
          ((StringBuilder)localObject).append(localJSONException.getMessage());
          QLog.i("RichStatus", 2, ((StringBuilder)localObject).toString(), localJSONException);
        }
      }
    } else {
      QLog.i("RichStatus", 2, String.format("topicFromJson %s", new Object[] { paramString }));
    }
  }
  
  public void topicPosFromJson(String paramString)
  {
    this.topicsPos.clear();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        int i = 0;
        Object localObject;
        while (i < localJSONArray.length())
        {
          localObject = (JSONObject)localJSONArray.get(i);
          int j = ((JSONObject)localObject).optInt("id");
          int k = ((JSONObject)localObject).optInt("topicPos");
          this.topicsPos.add(new Pair(Integer.valueOf(j), Integer.valueOf(k)));
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("topicPosFromJson");
          ((StringBuilder)localObject).append(localException.getMessage());
          QLog.i("RichStatus", 2, ((StringBuilder)localObject).toString(), localException);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("topicPosFromJson");
          ((StringBuilder)localObject).append(localJSONException.getMessage());
          QLog.i("RichStatus", 2, ((StringBuilder)localObject).toString(), localJSONException);
        }
      }
    } else {
      QLog.i("RichStatus", 2, String.format("topicPosFromJson %s", new Object[] { paramString }));
    }
  }
  
  public String topicPosToJson()
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    while (i < this.topicsPos.size())
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject4 = localObject1;
      try
      {
        localJSONObject.put("id", ((Pair)this.topicsPos.get(i)).first);
        localObject4 = localObject1;
        localJSONObject.put("topicPos", ((Pair)this.topicsPos.get(i)).second);
        Object localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject4 = localObject1;
          localObject3 = new JSONArray();
        }
        localObject4 = localObject3;
        ((JSONArray)localObject3).put(localJSONObject);
        localObject1 = localObject3;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject2 = localObject4;
      }
      i += 1;
    }
    if (localObject2 != null) {
      localObject2 = ((JSONArray)localObject2).toString();
    } else {
      localObject2 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.i("RichStatus", 2, String.format("topicPosToJson %s", new Object[] { localObject2 }));
    }
    return localObject2;
  }
  
  public String topicToJson()
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    while (i < this.topics.size())
    {
      if (!TextUtils.isEmpty((CharSequence)((Pair)this.topics.get(i)).second))
      {
        JSONObject localJSONObject = new JSONObject();
        Object localObject4 = localObject1;
        try
        {
          localJSONObject.put("id", ((Pair)this.topics.get(i)).first);
          localObject4 = localObject1;
          localJSONObject.put("topic", ((Pair)this.topics.get(i)).second);
          Object localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject4 = localObject1;
            localObject3 = new JSONArray();
          }
          localObject4 = localObject3;
          ((JSONArray)localObject3).put(localJSONObject);
          localObject1 = localObject3;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          localObject2 = localObject4;
        }
      }
      i += 1;
    }
    if (localObject2 != null) {
      localObject2 = ((JSONArray)localObject2).toString();
    } else {
      localObject2 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.i("RichStatus", 2, String.format("topicToJson %s", new Object[] { localObject2 }));
    }
    return localObject2;
  }
  
  public String topicToPlainText()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.topics.size())
    {
      if (!TextUtils.isEmpty((CharSequence)((Pair)this.topics.get(i)).second)) {
        localStringBuilder.append((String)((Pair)this.topics.get(i)).second);
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RichStatus", 2, String.format("topicToPlainText %s", new Object[] { localStringBuilder.toString() }));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatus
 * JD-Core Version:    0.7.0.1
 */