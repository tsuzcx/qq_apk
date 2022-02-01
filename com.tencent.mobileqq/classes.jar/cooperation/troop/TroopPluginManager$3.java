package cooperation.troop;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;

class TroopPluginManager$3
  extends TroopObserver
{
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append((Long)paramObject[0]);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        if (!this.a.equals(localObject)) {
          return;
        }
        this.b.removeObserver(this);
        this.j.a("com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", new TroopPluginManager.3.1(this, paramObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.3
 * JD-Core Version:    0.7.0.1
 */