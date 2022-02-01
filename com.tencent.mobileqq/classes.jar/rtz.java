import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class rtz
  implements bcfe
{
  rtz(rtv paramrtv) {}
  
  public void B_()
  {
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", anni.a(2131706378), null);
    bceg.a(3, -1500);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label95;
      }
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", anni.a(2131706381) + paramInt + "]", null);
      bceg.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "onDownloadFinish name=" + paramString1 + ", result=" + paramInt + ", filePath=" + paramString2, null);
      return;
      label95:
      rtv.a(this.a, true);
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", anni.a(2131706380) + paramInt + "]", null);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtz
 * JD-Core Version:    0.7.0.1
 */