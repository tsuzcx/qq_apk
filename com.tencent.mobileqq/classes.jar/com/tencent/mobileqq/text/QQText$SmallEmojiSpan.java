package com.tencent.mobileqq.text;

import ainr;
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
    ThreadManager.post(new ainr(this), 5, null, true);
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
  
  protected Drawable b()
  {
    Object localObject1 = new SmallEmoticonInfo(QQText.c());
    Object localObject2 = new Emoticon();
    ((Emoticon)localObject2).eId = String.valueOf(this.f);
    ((Emoticon)localObject2).epId = String.valueOf(this.e);
    if (!this.jdField_b_of_type_Boolean)
    {
      ((Emoticon)localObject2).jobType = 3;
      ((SmallEmoticonInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((Emoticon)localObject2);
      localObject1 = ((SmallEmoticonInfo)localObject1).a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((Drawable)localObject1).setBounds(0, 0, this.d, this.d);
      }
      return localObject1;
      ((Emoticon)localObject2).jobType = 3;
      ((SmallEmoticonInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((Emoticon)localObject2);
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject2 = EmoticonUtils.a();
        if (localObject2 != null)
        {
          localObject2 = ((EmoticonManager)localObject2).a(String.valueOf(this.e));
          if ((localObject2 != null) && (((EmoticonPackage)localObject2).isAPNG == 2)) {
            this.jdField_a_of_type_Boolean = true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "SmallEmojiSpan doGetDrawable: epid = " + this.e + " eid = " + this.f + " isAPNG = " + this.jdField_a_of_type_Boolean);
      }
      ((SmallEmoticonInfo)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      localObject1 = ((SmallEmoticonInfo)localObject1).b(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.SmallEmojiSpan
 * JD-Core Version:    0.7.0.1
 */