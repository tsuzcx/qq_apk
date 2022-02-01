package com.tencent.mobileqq.text.style;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SmallEmojiSpan
  extends EmoticonSpan
{
  int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b;
  public int c;
  
  public SmallEmojiSpan(char[] paramArrayOfChar, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(-1, paramInt, 2);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.mIsAPNG = paramBoolean2;
    paramArrayOfChar = EmosmUtils.a(paramArrayOfChar);
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 2))
    {
      this.b = paramArrayOfChar[0];
      this.c = paramArrayOfChar[1];
    }
    paramArrayOfChar = BaseApplicationImpl.getApplication().getRuntime();
    if (paramArrayOfChar != null) {
      this.jdField_a_of_type_JavaLangString = paramArrayOfChar.getAccount();
    }
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (paramArrayOfChar = "";; paramArrayOfChar = this.jdField_a_of_type_JavaLangString)
    {
      this.jdField_a_of_type_JavaLangString = paramArrayOfChar;
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "mEpId:" + this.b + ",mEId:" + this.c);
      }
      return;
    }
  }
  
  private void a()
  {
    SmallEmojiSpan.1 local1 = new SmallEmojiSpan.1(this);
    try
    {
      EmojiManager localEmojiManager = (EmojiManager)((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(this.jdField_a_of_type_JavaLangString)).getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
      if (localEmojiManager != null) {
        localEmojiManager.a.excuteOnNetThread(local1, true);
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
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((!this.mIsAPNG) && (paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2))
    {
      this.mIsAPNG = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "updateApngFlag mIsAPNG = true");
      }
    }
  }
  
  protected Drawable doGetDrwable()
  {
    Object localObject = new SmallEmoticonInfo(this.jdField_a_of_type_JavaLangString);
    Emoticon localEmoticon = new Emoticon();
    localEmoticon.eId = String.valueOf(this.c);
    localEmoticon.epId = String.valueOf(this.b);
    if (!this.jdField_a_of_type_Boolean)
    {
      localEmoticon.jobType = 3;
      ((SmallEmoticonInfo)localObject).emoticon = localEmoticon;
      localObject = ((SmallEmoticonInfo)localObject).getDrawable(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
    }
    for (;;)
    {
      if (localObject != null) {
        ((Drawable)localObject).setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      }
      return localObject;
      localEmoticon.jobType = 3;
      ((SmallEmoticonInfo)localObject).emoticon = localEmoticon;
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "SmallEmojiSpan doGetDrawable: epid = " + this.b + " eid = " + this.c + " isAPNG = " + this.mIsAPNG);
      }
      ((SmallEmoticonInfo)localObject).isAPNG = this.mIsAPNG;
      localObject = ((SmallEmoticonInfo)localObject).getBigDrawable(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
      a();
    }
  }
  
  public String getDescription()
  {
    String str = QQText.SMALL_EMOJI_SYMBOL;
    Emoticon localEmoticon = null;
    EmoticonManager localEmoticonManager = EmoticonUtils.getEmoticonManager();
    if (localEmoticonManager != null) {
      localEmoticon = localEmoticonManager.a(Integer.toString(this.b), Integer.toString(this.c));
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
    return this.b;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.jdField_a_of_type_Int);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public void setSize(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("tag.vasFont.enlarge", 2, "SmallEmojiSpan setSize size: " + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.SmallEmojiSpan
 * JD-Core Version:    0.7.0.1
 */