package com.tencent.mobileqq.text;

import aisu;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQText$SmallEmojiSpan
  extends QQText.EmoticonSpan
{
  boolean jdField_b_of_type_Boolean;
  int d;
  public int e;
  public int f;
  
  public QQText$SmallEmojiSpan(QQText paramQQText, char[] paramArrayOfChar, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramQQText, -1, paramInt, 2);
    this.d = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    paramQQText = EmosmUtils.a(paramArrayOfChar);
    if ((paramQQText != null) && (paramQQText.length == 2))
    {
      this.e = paramQQText[0];
      this.f = paramQQText[1];
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQText", 2, "mEpId:" + this.e + ",mEId:" + this.f);
    }
  }
  
  private void a()
  {
    ThreadManager.post(new aisu(this), 5, null, true);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public String a()
  {
    String str = "[小表情]";
    Emoticon localEmoticon = null;
    EmoticonManager localEmoticonManager = EmoticonUtils.a();
    if (localEmoticonManager != null) {
      localEmoticon = localEmoticonManager.a(Integer.toString(this.e), Integer.toString(this.f));
    }
    if (localEmoticon != null) {
      str = localEmoticon.character;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQText", 2, "descp:" + str);
    }
    return str;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("tag.vasFont.enlarge", 2, "SmallEmojiSpan setSize size: " + paramInt);
    }
    this.d = paramInt;
    this.b = paramInt;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if ((!this.jdField_a_of_type_Boolean) && (paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2))
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "updateApngFlag mIsAPNG = true");
      }
    }
  }
  
  protected Drawable b()
  {
    Object localObject = new SmallEmoticonInfo(QQText.c());
    Emoticon localEmoticon = new Emoticon();
    localEmoticon.eId = String.valueOf(this.f);
    localEmoticon.epId = String.valueOf(this.e);
    if (!this.jdField_b_of_type_Boolean)
    {
      localEmoticon.jobType = 3;
      ((SmallEmoticonInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
      localObject = ((SmallEmoticonInfo)localObject).a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
    }
    for (;;)
    {
      if (localObject != null) {
        ((Drawable)localObject).setBounds(0, 0, this.d, this.d);
      }
      return localObject;
      localEmoticon.jobType = 3;
      ((SmallEmoticonInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "SmallEmojiSpan doGetDrawable: epid = " + this.e + " eid = " + this.f + " isAPNG = " + this.jdField_a_of_type_Boolean);
      }
      ((SmallEmoticonInfo)localObject).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      localObject = ((SmallEmoticonInfo)localObject).b(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
      a();
    }
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.d);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.SmallEmojiSpan
 * JD-Core Version:    0.7.0.1
 */