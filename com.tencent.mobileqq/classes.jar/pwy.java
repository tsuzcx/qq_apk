import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class pwy
  implements awfg
{
  pwy(pwu parampwu) {}
  
  public void I_()
  {
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajjy.a(2131641821), null);
    awek.a(3, -1500);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label95;
      }
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajjy.a(2131641824) + paramInt + "]", null);
      awek.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "onDownloadFinish name=" + paramString1 + ", result=" + paramInt + ", filePath=" + paramString2, null);
      return;
      label95:
      pwu.a(this.a, true);
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajjy.a(2131641823) + paramInt + "]", null);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pwy
 * JD-Core Version:    0.7.0.1
 */