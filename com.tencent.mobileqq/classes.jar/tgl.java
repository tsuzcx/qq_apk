import android.view.View;

class tgl
  extends tgm
{
  tgl(tgk paramtgk) {}
  
  public void hide()
  {
    super.hide();
    if (tgk.a(this.a) != null)
    {
      tgk.a(this.a).setVisibility(4);
      tgk.a(this.a, 0);
    }
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    super.updateUnreadCount(paramInt, paramBoolean);
    if (paramInt == 0) {
      tgk.a(this.a, 0);
    }
    while ((paramInt <= tgk.a(this.a)) || (tgk.a(this.a) == null)) {
      return;
    }
    tgk.a(this.a).setVisibility(0);
    tgk.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tgl
 * JD-Core Version:    0.7.0.1
 */