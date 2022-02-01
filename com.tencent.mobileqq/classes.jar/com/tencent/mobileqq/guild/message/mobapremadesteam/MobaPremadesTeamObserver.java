package com.tencent.mobileqq.guild.message.mobapremadesteam;

import com.tencent.mobileqq.app.BusinessObserver;

public class MobaPremadesTeamObserver
  implements BusinessObserver
{
  public static final int a;
  private static int b;
  
  static
  {
    int i = b;
    b = i + 1;
    a = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != a) {
      return;
    }
    a(paramBoolean);
  }
  
  protected void a(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.mobapremadesteam.MobaPremadesTeamObserver
 * JD-Core Version:    0.7.0.1
 */