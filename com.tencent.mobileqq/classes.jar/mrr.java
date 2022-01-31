import android.os.Bundle;
import com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity;

public class mrr
  implements ajfe
{
  public mrr(LebaSearchMoreInfoActivity paramLebaSearchMoreInfoActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (Bundle)paramObject;
    switch (paramInt)
    {
    default: 
      return;
    case 17: 
      paramBoolean = paramObject.getBoolean("result");
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramBoolean)
      {
        paramObject = this.a.getString(2131630582);
        localStringBuilder.append(paramObject);
        localStringBuilder.append(this.a.getString(2131630580));
        localStringBuilder.append(this.a.c);
        if (!paramBoolean) {
          break label233;
        }
        paramInt = 2;
        label104:
        bbmy.a(this.a, paramInt, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
        paramObject = this.a;
        if (!paramBoolean) {
          break label238;
        }
      }
      break;
    }
    label233:
    label238:
    for (paramInt = -1;; paramInt = 0)
    {
      paramObject.setResult(paramInt);
      return;
      this.a.a = paramObject.getBoolean("isOpen");
      this.a.c = paramObject.getString("name");
      if (this.a.c != null) {
        this.a.b = this.a.getString(2131630642, new Object[] { this.a.c });
      }
      LebaSearchMoreInfoActivity.a(this.a);
      return;
      paramObject = this.a.getString(2131630581);
      break;
      paramInt = 1;
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     mrr
 * JD-Core Version:    0.7.0.1
 */