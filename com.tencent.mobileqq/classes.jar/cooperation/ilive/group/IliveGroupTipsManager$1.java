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
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" exit page");
      QLog.d("IliveGroupTipsManager", 1, localStringBuilder.toString());
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.a(this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Long), IliveGroupTipsManager.b);
      return;
    }
    IliveGroupTipsManager.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsManager.1
 * JD-Core Version:    0.7.0.1
 */