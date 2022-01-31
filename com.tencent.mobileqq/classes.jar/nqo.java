import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;

public class nqo
  implements nqm
{
  public nqo(MediaPlayer paramMediaPlayer) {}
  
  public void a(nqk paramnqk)
  {
    if ((this.a.jdField_a_of_type_Nqr != null) && (!this.a.jdField_a_of_type_Nqr.a()) && (!this.a.e) && (this.a.jdField_a_of_type_Nqi.b() < 2000000L) && (!this.a.jdField_a_of_type_Nqi.b()))
    {
      this.a.e = true;
      this.a.jdField_a_of_type_Nqq.sendMessage(this.a.jdField_a_of_type_Nqq.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqo
 * JD-Core Version:    0.7.0.1
 */