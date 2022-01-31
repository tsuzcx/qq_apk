package com.tencent.mobileqq.richstatus;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
  public static final ColorStateList sActionColor;
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
  private boolean isEmptyStatus;
  public boolean isFirstReadUins = true;
  public byte[] key;
  public int latitude;
  public int locationPosition;
  public String locationText;
  public int lontitude;
  public ArrayList mStickerInfos;
  public List mUins;
  public ArrayList plainText;
  public HashMap sigZanInfo;
  public long time;
  public int tplId;
  public int tplType;
  
  static
  {
    int[] arrayOfInt = new int[0];
    sActionColor = new ColorStateList(new int[][] { { 16842919 }, arrayOfInt }, new int[] { -2039584, -8947849 });
  }
  
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
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    Object localObject1 = null;
    int i = 0;
    label82:
    int j;
    int k;
    label114:
    int m;
    for (;;)
    {
      if (localByteBuffer.hasRemaining())
      {
        if (localByteBuffer.remaining() >= 2) {
          break label82;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          localRichStatus.a((String)localObject1);
        }
        return localRichStatus;
        j = localByteBuffer.get();
        k = localByteBuffer.get();
        if (j >= 0) {
          break label885;
        }
        j += 256;
        if (k >= 0) {
          break label882;
        }
        k += 256;
        if (localByteBuffer.remaining() >= k) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
        }
      }
      m = i + 2;
      if ((j <= 0) || (j >= 128)) {
        break;
      }
      localObject2 = new String(paramArrayOfByte, m, k);
      i = k + m;
      localByteBuffer.position(i);
      switch (j)
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
          break label879;
        }
        localRichStatus.a((String)localObject1);
        localObject1 = null;
        label263:
        if (localRichStatus.plainText != null) {}
        for (localRichStatus.locationPosition = localRichStatus.plainText.size();; localRichStatus.locationPosition = 0)
        {
          localRichStatus.locationText = ((String)localObject2);
          break;
        }
        localObject1 = (String)localObject1 + (String)localObject2;
      }
    }
    switch (j)
    {
    default: 
    case 129: 
    case 130: 
    case 144: 
    case 145: 
    case 146: 
    case 147: 
      for (;;)
      {
        label396:
        i = m + k;
        localByteBuffer.position(i);
        break;
        if (localByteBuffer.remaining() < 8)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
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
              QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
            }
          }
          else
          {
            localRichStatus.lontitude = localByteBuffer.getInt();
            localRichStatus.latitude = localByteBuffer.getInt();
            continue;
            localRichStatus.feedsId = new String(paramArrayOfByte, m, k);
            if (QLog.isColorLevel())
            {
              QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte) + ",sign feeds id=" + localRichStatus.feedsId);
              continue;
              localRichStatus.tplId = localByteBuffer.getInt();
              continue;
              localRichStatus.tplType = localByteBuffer.getInt();
              continue;
              localRichStatus.actId = localByteBuffer.getInt();
            }
          }
        }
      }
    }
    Object localObject3 = new byte[k];
    localByteBuffer.get((byte[])localObject3);
    Object localObject2 = new richstatus_sticker.RichStatus_Sticker();
    for (;;)
    {
      try
      {
        ((richstatus_sticker.RichStatus_Sticker)localObject2).mergeFrom((byte[])localObject3);
        if ((!((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.has()) || (((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.size() <= 0)) {
          break label396;
        }
        if (localRichStatus.mStickerInfos == null)
        {
          localRichStatus.mStickerInfos = new ArrayList();
          break label888;
          if (i >= ((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.size()) {
            break label836;
          }
          localObject3 = (richstatus_sticker.StickerInfo)((richstatus_sticker.RichStatus_Sticker)localObject2).sticker_info.get(i);
          RichStatus.StickerInfo localStickerInfo = new RichStatus.StickerInfo();
          localStickerInfo.jdField_a_of_type_Int = ((richstatus_sticker.StickerInfo)localObject3).uint32_id.get();
          localStickerInfo.jdField_a_of_type_Float = ((richstatus_sticker.StickerInfo)localObject3).float_posX.get();
          localStickerInfo.b = ((richstatus_sticker.StickerInfo)localObject3).float_posY.get();
          localStickerInfo.c = ((richstatus_sticker.StickerInfo)localObject3).float_width.get();
          localStickerInfo.d = ((richstatus_sticker.StickerInfo)localObject3).float_height.get();
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
      break label396;
      label836:
      if (!QLog.isColorLevel()) {
        break label396;
      }
      QLog.d("RichStatus", 2, "parseStatus sticker info size = " + localRichStatus.mStickerInfos.size());
      break label396;
      label879:
      break label263;
      label882:
      break label114;
      label885:
      break;
      label888:
      i = 0;
    }
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
    return localObject;
  }
  
  public int countLength()
  {
    return (countUtfLength() - 12 + 2) / 3;
  }
  
  public int countUtfLength()
  {
    int k = 0;
    if (!TextUtils.isEmpty(this.actionText)) {}
    for (int i = a(this.actionText) + 12 + 0;; i = 0)
    {
      int j = i;
      if (!TextUtils.isEmpty(this.dataText)) {
        j = i + (a(this.dataText) + 2);
      }
      i = j;
      if (!TextUtils.isEmpty(this.locationText)) {
        i = j + (a(this.locationText) + 12);
      }
      Object localObject1;
      Object localObject2;
      if (this.plainText != null)
      {
        localObject1 = this.plainText.iterator();
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break label137;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label298;
        }
        i = a((String)localObject2) + 2 + i;
      }
      label137:
      label298:
      for (;;)
      {
        break;
        j = i;
        j += 12;
        if ((this.mStickerInfos != null) && (this.mStickerInfos.size() > 0))
        {
          localObject1 = new richstatus_sticker.RichStatus_Sticker();
          i = k;
          while (i < this.mStickerInfos.size())
          {
            localObject2 = (RichStatus.StickerInfo)this.mStickerInfos.get(i);
            richstatus_sticker.StickerInfo localStickerInfo = new richstatus_sticker.StickerInfo();
            localStickerInfo.uint32_id.set(((RichStatus.StickerInfo)localObject2).jdField_a_of_type_Int);
            localStickerInfo.float_posX.set(((RichStatus.StickerInfo)localObject2).jdField_a_of_type_Float);
            localStickerInfo.float_posY.set(((RichStatus.StickerInfo)localObject2).b);
            localStickerInfo.float_width.set(((RichStatus.StickerInfo)localObject2).c);
            localStickerInfo.float_height.set(((RichStatus.StickerInfo)localObject2).d);
            ((richstatus_sticker.RichStatus_Sticker)localObject1).sticker_info.add(localStickerInfo);
            i += 1;
          }
          return ((richstatus_sticker.RichStatus_Sticker)localObject1).toByteArray().length + 2 + j;
        }
        return j;
      }
    }
  }
  
  public byte[] encode()
  {
    int k = 0;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(countUtfLength());
    a(localByteBuffer, 1, this.actionText);
    a(localByteBuffer, 2, this.dataText);
    int i = 0;
    while (i < this.locationPosition)
    {
      a(localByteBuffer, 3, (String)this.plainText.get(i));
      i += 1;
    }
    a(localByteBuffer, 4, this.locationText);
    if (this.plainText != null) {}
    for (i = this.plainText.size();; i = 0)
    {
      int j = this.locationPosition;
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
    if ((this.mStickerInfos != null) && (this.mStickerInfos.size() > 0))
    {
      Object localObject = new richstatus_sticker.RichStatus_Sticker();
      i = k;
      while (i < this.mStickerInfos.size())
      {
        RichStatus.StickerInfo localStickerInfo = (RichStatus.StickerInfo)this.mStickerInfos.get(i);
        richstatus_sticker.StickerInfo localStickerInfo1 = new richstatus_sticker.StickerInfo();
        localStickerInfo1.uint32_id.set(localStickerInfo.jdField_a_of_type_Int);
        localStickerInfo1.float_posX.set(localStickerInfo.jdField_a_of_type_Float);
        localStickerInfo1.float_posY.set(localStickerInfo.b);
        localStickerInfo1.float_width.set(localStickerInfo.c);
        localStickerInfo1.float_height.set(localStickerInfo.d);
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
    if (TextUtils.isEmpty(this.locationText)) {
      return paramCharSequence;
    }
    Object localObject2 = new StringBuilder().append("[L] ").append(this.locationText);
    if (paramCharSequence != null) {}
    for (Object localObject1 = " " + paramCharSequence;; localObject1 = "")
    {
      localObject1 = new SpannableString((String)localObject1);
      try
      {
        localObject2 = BitmapFactory.decodeResource(paramResources, 2130845333);
        int i = (int)(0.9F * paramFloat + 0.5F);
        int j = ((Bitmap)localObject2).getWidth() * i / ((Bitmap)localObject2).getHeight();
        paramResources = new StatableBitmapDrawable(paramResources, (Bitmap)localObject2, false, true);
        paramResources.setBounds(0, 0, j, i);
        ((SpannableString)localObject1).setSpan(new OffsetableImageSpan(paramResources, 0).a(-0.1F), 0, "[L]".length(), 33);
        return localObject1;
      }
      catch (OutOfMemoryError paramResources) {}
    }
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
    int j = 0;
    if ((this.enableSummaryCached) && (this.cachedStatusContent != null)) {
      return this.cachedStatusContent;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    int i = 0;
    while (i < this.locationPosition)
    {
      a(localStringBuilder, (String)this.plainText.get(i));
      i += 1;
    }
    i = j;
    if (this.plainText != null) {
      i = this.plainText.size();
    }
    j = this.locationPosition;
    while (j < i)
    {
      a(localStringBuilder, (String)this.plainText.get(j));
      j += 1;
    }
    if (this.enableSummaryCached) {
      this.cachedStatusContent = localStringBuilder.toString();
    }
    return localStringBuilder.toString();
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
        break label72;
      }
      i = 0;
    }
    label50:
    label72:
    for (;;)
    {
      break;
      j = 1;
      return (this.actionId == 0) && (this.dataId == 0) && (j != 0);
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
    int k = paramString.length();
    if (k > str.length()) {
      paramString.append(' ');
    }
    int i = 0;
    while (i < this.locationPosition)
    {
      a(paramString, (String)this.plainText.get(i));
      i += 1;
    }
    if (this.plainText != null) {}
    for (i = this.plainText.size();; i = 0)
    {
      int j = this.locationPosition;
      while (j < i)
      {
        a(paramString, (String)this.plainText.get(j));
        j += 1;
      }
    }
    paramString = new SpannableString(paramString.toString().trim());
    if (k > str.length()) {
      paramString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramInt1, paramInt2), 0, k, 33);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.RichStatus
 * JD-Core Version:    0.7.0.1
 */