package com.tencent.mobileqq.text.style;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SmallEmojiSpan
  extends EmoticonSpan
  implements ISmallEmojiSpan
{
  int a;
  public int b;
  public int c;
  public boolean d;
  private String e;
  
  public SmallEmojiSpan(char[] paramArrayOfChar, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(-1, paramInt, 2);
    this.a = paramInt;
    this.d = paramBoolean1;
    this.mIsAPNG = paramBoolean2;
    paramArrayOfChar = EmosmUtils.a(paramArrayOfChar);
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 2))
    {
      this.b = paramArrayOfChar[0];
      this.c = paramArrayOfChar[1];
    }
    paramArrayOfChar = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (paramArrayOfChar != null) {
      this.e = paramArrayOfChar.getAccount();
    }
    String str = this.e;
    paramArrayOfChar = str;
    if (str == null) {
      paramArrayOfChar = "";
    }
    this.e = paramArrayOfChar;
    if (QLog.isColorLevel())
    {
      paramArrayOfChar = new StringBuilder();
      paramArrayOfChar.append("mEpId:");
      paramArrayOfChar.append(this.b);
      paramArrayOfChar.append(",mEId:");
      paramArrayOfChar.append(this.c);
      QLog.d("QQText", 2, paramArrayOfChar.toString());
    }
  }
  
  private void a()
  {
    SmallEmojiSpan.1 local1 = new SmallEmojiSpan.1(this);
    Object localObject = null;
    try
    {
      IEmojiManagerService localIEmojiManagerService = (IEmojiManagerService)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getRuntimeService(IEmojiManagerService.class, "");
      localObject = localIEmojiManagerService;
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    if (localObject != null) {
      localObject.getEmoQueue().excuteOnNetThread(local1, true);
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
    Object localObject1 = new SmallEmoticonInfo(this.e);
    Object localObject2 = new Emoticon();
    ((Emoticon)localObject2).eId = String.valueOf(this.c);
    ((Emoticon)localObject2).epId = String.valueOf(this.b);
    if (!this.d)
    {
      ((Emoticon)localObject2).jobType = 3;
      ((SmallEmoticonInfo)localObject1).emoticon = ((Emoticon)localObject2);
      localObject1 = ((SmallEmoticonInfo)localObject1).getDrawable(MobileQQ.getContext(), MobileQQ.getContext().getResources().getDisplayMetrics().density);
    }
    else
    {
      ((Emoticon)localObject2).jobType = 3;
      ((SmallEmoticonInfo)localObject1).emoticon = ((Emoticon)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("SmallEmojiSpan doGetDrawable: epid = ");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append(" eid = ");
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append(" isAPNG = ");
        ((StringBuilder)localObject2).append(this.mIsAPNG);
        QLog.d("QQText", 2, ((StringBuilder)localObject2).toString());
      }
      ((SmallEmoticonInfo)localObject1).isAPNG = this.mIsAPNG;
      localObject1 = ((SmallEmoticonInfo)localObject1).getBigDrawable(MobileQQ.getContext(), MobileQQ.getContext().getResources().getDisplayMetrics().density);
      a();
    }
    if (localObject1 != null)
    {
      int i = this.a;
      ((Drawable)localObject1).setBounds(0, 0, i, i);
    }
    return localObject1;
  }
  
  public float getBottom()
  {
    return this.eBottom;
  }
  
  public String getDescription()
  {
    String str = QQText.SMALL_EMOJI_SYMBOL;
    Object localObject = EmoticonPanelUtils.d();
    if (localObject != null) {
      localObject = ((IEmoticonManagerService)localObject).syncFindEmoticonById(Integer.toString(this.b), Integer.toString(this.c));
    } else {
      localObject = null;
    }
    if (localObject != null) {
      str = ((Emoticon)localObject).character;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("descp:");
      ((StringBuilder)localObject).append(str);
      QLog.d("QQText", 2, ((StringBuilder)localObject).toString());
    }
    return str;
  }
  
  public int getEId()
  {
    return this.c;
  }
  
  public int getEpId()
  {
    return this.b;
  }
  
  public int getIndex()
  {
    return this.b;
  }
  
  public float getLeft()
  {
    return this.eLeft;
  }
  
  public float getRight()
  {
    return this.eRight;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.a);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.a;
  }
  
  public float getTop()
  {
    return this.eTop;
  }
  
  public void setIsAnim(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setSize(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SmallEmojiSpan setSize size: ");
      localStringBuilder.append(paramInt);
      QLog.i("tag.vasFont.enlarge", 2, localStringBuilder.toString());
    }
    this.a = paramInt;
    this.size = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.SmallEmojiSpan
 * JD-Core Version:    0.7.0.1
 */