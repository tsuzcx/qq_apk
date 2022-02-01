import android.os.Handler;

class nir
  extends niy
{
  nir(niq paramniq) {}
  
  public boolean a(int paramInt, String paramString, mze parammze)
  {
    bkdp.c(this.a.a, "onRoomSelfExit " + paramInt + " " + paramString);
    niq.a(this.a).removeCallbacksAndMessages(null);
    niq.a(this.a).sendEmptyMessage(2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nir
 * JD-Core Version:    0.7.0.1
 */