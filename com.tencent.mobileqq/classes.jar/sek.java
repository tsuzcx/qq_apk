import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class sek
  implements bcya
{
  sek(seg paramseg) {}
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label95;
      }
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", anvx.a(2131707070) + paramInt + "]", null);
      bcxc.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "onDownloadFinish name=" + paramString1 + ", result=" + paramInt + ", filePath=" + paramString2, null);
      return;
      label95:
      seg.a(this.a, true);
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", anvx.a(2131707069) + paramInt + "]", null);
    }
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", anvx.a(2131707067), null);
    bcxc.a(3, -1500);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sek
 * JD-Core Version:    0.7.0.1
 */