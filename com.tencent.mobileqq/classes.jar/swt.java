import com.tencent.qphone.base.util.BaseApplication;

public class swt
  implements wam
{
  private swu jdField_a_of_type_Swu;
  
  public swt(sws paramsws, swu paramswu)
  {
    this.jdField_a_of_type_Swu = paramswu;
  }
  
  public void onFailure(String paramString)
  {
    veg.e(sws.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void onFinish(boolean paramBoolean)
  {
    sws.a(this.jdField_a_of_type_Sws);
    if (sws.b(this.jdField_a_of_type_Sws) == 0)
    {
      veg.b(sws.a, "all ffmpeg commands have already finished. start clearing cache.");
      sws.a(this.jdField_a_of_type_Sws);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    veg.b(sws.a, "start executing ffmpeg commands.");
  }
  
  public void onSuccess(String paramString)
  {
    if (vyi.a(BaseApplication.getContext(), this.jdField_a_of_type_Swu.d, this.jdField_a_of_type_Swu.e))
    {
      veg.b(sws.a, "save video to album success.");
      vel.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    veg.e(sws.a, "save video to album failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swt
 * JD-Core Version:    0.7.0.1
 */