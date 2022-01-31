import com.tencent.qphone.base.util.BaseApplication;

public class swq
  implements waj
{
  private swr jdField_a_of_type_Swr;
  
  public swq(swp paramswp, swr paramswr)
  {
    this.jdField_a_of_type_Swr = paramswr;
  }
  
  public void onFailure(String paramString)
  {
    ved.e(swp.a, "fail to execute ffmpeg command. error message : %s.", new Object[] { paramString });
  }
  
  public void onFinish(boolean paramBoolean)
  {
    swp.a(this.jdField_a_of_type_Swp);
    if (swp.b(this.jdField_a_of_type_Swp) == 0)
    {
      ved.b(swp.a, "all ffmpeg commands have already finished. start clearing cache.");
      swp.a(this.jdField_a_of_type_Swp);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    ved.b(swp.a, "start executing ffmpeg commands.");
  }
  
  public void onSuccess(String paramString)
  {
    if (vyf.a(BaseApplication.getContext(), this.jdField_a_of_type_Swr.d, this.jdField_a_of_type_Swr.e))
    {
      ved.b(swp.a, "save video to album success.");
      vei.a("video_edit", "video_save_local", 0, 0, new String[0]);
      return;
    }
    ved.e(swp.a, "save video to album failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swq
 * JD-Core Version:    0.7.0.1
 */