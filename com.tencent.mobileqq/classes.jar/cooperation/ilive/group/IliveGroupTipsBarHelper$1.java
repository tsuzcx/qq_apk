package cooperation.ilive.group;

import androidx.annotation.UiThread;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.group.entity.IliveGroupTipsEntity;

class IliveGroupTipsBarHelper$1
  extends IliveGroupObserver
{
  IliveGroupTipsBarHelper$1(IliveGroupTipsBarHelper paramIliveGroupTipsBarHelper) {}
  
  public void a()
  {
    IliveGroupTipsBarHelper.a(this.a, null);
    if (!this.a.c()) {
      IliveGroupTipsBarHelper.a(this.a);
    }
  }
  
  @UiThread
  public void a(String paramString, IliveGroupTipsEntity paramIliveGroupTipsEntity)
  {
    if (paramIliveGroupTipsEntity == null)
    {
      QLog.i("IliveGroupTipsBarHelper", 1, "handleIliveGroupData entity request error");
      return;
    }
    IliveGroupTipsBarHelper.a(this.a, paramIliveGroupTipsEntity);
    StringBuilder localStringBuilder = new StringBuilder().append("handleIliveGroupData ");
    if (IliveGroupTipsBarHelper.a(this.a) == null)
    {
      paramIliveGroupTipsEntity = " data = null";
      QLog.i("IliveGroupTipsBarHelper", 1, paramIliveGroupTipsEntity + " source = " + paramString);
      if ((IliveGroupTipsBarHelper.a(this.a) == null) || (!IliveGroupTipsBarHelper.a(this.a).a)) {
        break label151;
      }
    }
    label151:
    for (boolean bool = true;; bool = false)
    {
      IliveGroupTipsBarHelper.a(this.a, bool);
      if (bool) {
        break label156;
      }
      this.a.c();
      return;
      paramIliveGroupTipsEntity = " value = " + IliveGroupTipsBarHelper.a(this.a).toString();
      break;
    }
    label156:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsBarHelper.1
 * JD-Core Version:    0.7.0.1
 */