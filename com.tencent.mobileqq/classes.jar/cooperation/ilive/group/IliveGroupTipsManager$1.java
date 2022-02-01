package cooperation.ilive.group;

import com.tencent.qphone.base.util.QLog;

class IliveGroupTipsManager$1
  implements Runnable
{
  IliveGroupTipsManager$1(IliveGroupTipsManager paramIliveGroupTipsManager, boolean paramBoolean, String paramString, long paramLong) {}
  
  public void run()
  {
    if (IliveGroupTipsManager.a(this.this$0) == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGroupPushHandle isLive = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" exit page");
      QLog.d("IliveGroupTipsManager", 1, localStringBuilder.toString());
      return;
    }
    if (this.a)
    {
      this.this$0.a(this.b, String.valueOf(this.c), IliveGroupTipsManager.b);
      return;
    }
    IliveGroupTipsManager.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsManager.1
 * JD-Core Version:    0.7.0.1
 */