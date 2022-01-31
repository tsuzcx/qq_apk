import com.tencent.qphone.base.util.BaseApplication;

public class sjx
  implements vnq
{
  private sjy jdField_a_of_type_Sjy;
  
  public sjx(sjw paramsjw, sjy paramsjy)
  {
    this.jdField_a_of_type_Sjy = paramsjy;
  }
  
  public void onFailure(String paramString)
  {
    urk.e(sjw.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void onFinish(boolean paramBoolean)
  {
    sjw.a(this.jdField_a_of_type_Sjw);
    if (sjw.b(this.jdField_a_of_type_Sjw) == 0)
    {
      urk.b(sjw.a, "all ffmpeg commands have already finished. start clearing cache.");
      sjw.a(this.jdField_a_of_type_Sjw);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    urk.b(sjw.a, "start executing ffmpeg commands.");
  }
  
  public void onSuccess(String paramString)
  {
    if (vlm.a(BaseApplication.getContext(), this.jdField_a_of_type_Sjy.d, this.jdField_a_of_type_Sjy.e))
    {
      urk.b(sjw.a, "save video to album success.");
      urp.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    urk.e(sjw.a, "save video to album failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sjx
 * JD-Core Version:    0.7.0.1
 */