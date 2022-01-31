import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;

public class nve
  implements nvc
{
  public nve(MediaPlayer paramMediaPlayer) {}
  
  public void a(nva paramnva)
  {
    if ((this.a.jdField_a_of_type_Nvh != null) && (!this.a.jdField_a_of_type_Nvh.a()) && (!this.a.e) && (this.a.jdField_a_of_type_Nuy.b() < 2000000L) && (!this.a.jdField_a_of_type_Nuy.b()))
    {
      this.a.e = true;
      this.a.jdField_a_of_type_Nvg.sendMessage(this.a.jdField_a_of_type_Nvg.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nve
 * JD-Core Version:    0.7.0.1
 */