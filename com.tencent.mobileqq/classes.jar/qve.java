import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.qphone.base.util.QLog;

public class qve
  extends NativeText
{
  protected float a = 0.0F;
  
  public qve(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative.setBackgroundColor(paramVafContext.getContext().getResources().getColor(2131167296));
  }
  
  private String a(String paramString1, String paramString2)
  {
    return String.format(paramString1, new Object[] { paramString2 });
  }
  
  public void a(long paramLong)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, new qvh(this, String.valueOf(paramLong)));
    if (localReadInJoyUserInfo != null)
    {
      setText(prg.a(localReadInJoyUserInfo.nick));
      return;
    }
    setText(ReadInJoyUserInfoModule.a());
  }
  
  public void a(long paramLong, String paramString)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, new qvg(this, String.valueOf(paramLong), paramString));
    if ((localReadInJoyUserInfo != null) && (!TextUtils.isEmpty(localReadInJoyUserInfo.decorationName)))
    {
      setText(prg.a(localReadInJoyUserInfo.decorationName));
      return;
    }
    setText(prg.a(paramString));
  }
  
  public void a(String paramString, long paramLong)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, new qvf(this, String.valueOf(paramLong), paramString));
    if (localReadInJoyUserInfo != null)
    {
      setText(a(paramString, prg.a(localReadInJoyUserInfo.nick)));
      return;
    }
    setText(a(paramString, ReadInJoyUserInfoModule.a()));
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    if (this.a > 0.0F) {
      this.mNative.setLineSpacing(this.a, 1.0F);
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.setAttribute(paramInt, paramString);
      try
      {
        this.a = Utils.dp2px(Double.valueOf(paramString).doubleValue());
        return true;
      }
      catch (Exception localException)
      {
        QLog.d("ReadInjoyTextView", 1, "", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qve
 * JD-Core Version:    0.7.0.1
 */