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
    boolean bool = true;
    if (paramIliveGroupTipsEntity == null)
    {
      QLog.i("IliveGroupTipsBarHelper", 1, "handleIliveGroupData entity request error");
      return;
    }
    IliveGroupTipsBarHelper.a(this.a, paramIliveGroupTipsEntity);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleIliveGroupData ");
    if (IliveGroupTipsBarHelper.a(this.a) == null)
    {
      paramIliveGroupTipsEntity = " data = null";
    }
    else
    {
      paramIliveGroupTipsEntity = new StringBuilder();
      paramIliveGroupTipsEntity.append(" value = ");
      paramIliveGroupTipsEntity.append(IliveGroupTipsBarHelper.a(this.a).toString());
      paramIliveGroupTipsEntity = paramIliveGroupTipsEntity.toString();
    }
    localStringBuilder.append(paramIliveGroupTipsEntity);
    localStringBuilder.append(" source = ");
    localStringBuilder.append(paramString);
    QLog.i("IliveGroupTipsBarHelper", 1, localStringBuilder.toString());
    if ((IliveGroupTipsBarHelper.a(this.a) == null) || (!IliveGroupTipsBarHelper.a(this.a).a)) {
      bool = false;
    }
    IliveGroupTipsBarHelper.a(this.a, bool);
    if (!bool)
    {
      this.a.c();
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsBarHelper.1
 * JD-Core Version:    0.7.0.1
 */