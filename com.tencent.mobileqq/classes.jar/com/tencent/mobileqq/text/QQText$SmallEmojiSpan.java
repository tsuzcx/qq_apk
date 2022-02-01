package com.tencent.mobileqq.text;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import aqyy;
import areb;
import avsq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QQText$SmallEmojiSpan
  extends QQText.EmoticonSpan
{
  private WeakReference<Drawable> mDrawableRef;
  public int mEId;
  public int mEpId;
  boolean mIsAnim;
  int mSize;
  
  public QQText$SmallEmojiSpan(char[] paramArrayOfChar, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(-1, paramInt, 2);
    this.mSize = paramInt;
    this.mIsAnim = paramBoolean1;
    this.mIsAPNG = paramBoolean2;
    paramArrayOfChar = aqyy.a(paramArrayOfChar);
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 2))
    {
      this.mEpId = paramArrayOfChar[0];
      this.mEId = paramArrayOfChar[1];
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQText", 2, "mEpId:" + this.mEpId + ",mEId:" + this.mEId);
    }
  }
  
  private void checkJsonExist()
  {
    QQText.SmallEmojiSpan.1 local1 = new QQText.SmallEmojiSpan.1(this);
    try
    {
      areb localareb = (areb)((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(QQText.access$000())).getManager(43);
      if (localareb != null) {
        localareb.a.execute(local1, 128, true);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  protected Drawable doGetDrwable()
  {
    Object localObject = new SmallEmoticonInfo(QQText.access$000());
    Emoticon localEmoticon = new Emoticon();
    localEmoticon.eId = String.valueOf(this.mEId);
    localEmoticon.epId = String.valueOf(this.mEpId);
    if (!this.mIsAnim)
    {
      localEmoticon.jobType = 3;
      ((SmallEmoticonInfo)localObject).emoticon = localEmoticon;
      localObject = ((SmallEmoticonInfo)localObject).getDrawable(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
    }
    for (;;)
    {
      if (localObject != null) {
        ((Drawable)localObject).setBounds(0, 0, this.mSize, this.mSize);
      }
      return localObject;
      localEmoticon.jobType = 3;
      ((SmallEmoticonInfo)localObject).emoticon = localEmoticon;
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "SmallEmojiSpan doGetDrawable: epid = " + this.mEpId + " eid = " + this.mEId + " isAPNG = " + this.mIsAPNG);
      }
      ((SmallEmoticonInfo)localObject).isAPNG = this.mIsAPNG;
      localObject = ((SmallEmoticonInfo)localObject).getBigDrawable(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
      checkJsonExist();
    }
  }
  
  public String getDescription()
  {
    String str = QQText.SMALL_EMOJI_SYMBOL;
    Emoticon localEmoticon = null;
    avsq localavsq = EmoticonUtils.getEmoticonManager();
    if (localavsq != null) {
      localEmoticon = localavsq.a(Integer.toString(this.mEpId), Integer.toString(this.mEId));
    }
    if (localEmoticon != null) {
      str = localEmoticon.character;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQText", 2, "descp:" + str);
    }
    return str;
  }
  
  public int getIndex()
  {
    return this.mEpId;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.mSize);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.mSize;
  }
  
  public void setSize(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("tag.vasFont.enlarge", 2, "SmallEmojiSpan setSize size: " + paramInt);
    }
    this.mSize = paramInt;
    this.size = paramInt;
  }
  
  public void updateApngFlag(EmoticonPackage paramEmoticonPackage)
  {
    if ((!this.mIsAPNG) && (paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2))
    {
      this.mIsAPNG = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "updateApngFlag mIsAPNG = true");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.SmallEmojiSpan
 * JD-Core Version:    0.7.0.1
 */