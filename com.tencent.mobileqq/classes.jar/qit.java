import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class qit
  implements axeq
{
  qit(qip paramqip) {}
  
  public void G_()
  {
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131707617), null);
    axdu.a(3, -1500);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label95;
      }
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131707620) + paramInt + "]", null);
      axdu.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "onDownloadFinish name=" + paramString1 + ", result=" + paramInt + ", filePath=" + paramString2, null);
      return;
      label95:
      qip.a(this.a, true);
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131707619) + paramInt + "]", null);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qit
 * JD-Core Version:    0.7.0.1
 */