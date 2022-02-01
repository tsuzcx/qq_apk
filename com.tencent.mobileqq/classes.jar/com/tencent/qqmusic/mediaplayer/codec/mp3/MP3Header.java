package com.tencent.qqmusic.mediaplayer.codec.mp3;

class MP3Header
{
  public static final int MPEG1 = 3;
  public static final int MPEG2 = 2;
  public static final int MPEG25 = 0;
  private int[][][] bitrate;
  private int bitrate_index;
  private int framesize;
  private int layer;
  private int lsf;
  private int mode;
  private int mode_extension;
  private int padding;
  private int protection_bit;
  private int[][] samplingRate;
  private int sampling_frequency;
  private int sideinfosize;
  private int verID;
  
  MP3Header()
  {
    Object localObject = { { 0, 32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448 }, { 0, 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384 }, { 0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320 } };
    int[] arrayOfInt1 = { 0, 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256 };
    int[] arrayOfInt2 = { 0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 };
    this.bitrate = new int[][][] { localObject, { arrayOfInt1, { 0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160 }, arrayOfInt2 } };
    localObject = new int[] { 11025, 12000, 8000, 0 };
    arrayOfInt1 = new int[] { 0, 0, 0, 0 };
    arrayOfInt2 = new int[] { 44100, 48000, 32000, 0 };
    this.samplingRate = new int[][] { localObject, arrayOfInt1, { 22050, 24000, 16000, 0 }, arrayOfInt2 };
  }
  
  protected void decode(int paramInt)
  {
    this.verID = (paramInt >> 19 & 0x3);
    this.layer = (4 - (paramInt >> 17 & 0x3));
    this.protection_bit = (paramInt >> 16 & 0x1);
    this.bitrate_index = (paramInt >> 12 & 0xF);
    this.sampling_frequency = (paramInt >> 10 & 0x3);
    this.padding = (paramInt >> 9 & 0x1);
    this.mode = (paramInt >> 6 & 0x3);
    this.mode_extension = (paramInt >> 4 & 0x3);
    if (this.verID == 3) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    this.lsf = paramInt;
    paramInt = this.layer;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        Object localObject = this.bitrate;
        paramInt = this.lsf;
        this.framesize = (localObject[paramInt][2][this.bitrate_index] * 144000);
        int j = this.framesize;
        localObject = this.samplingRate;
        int i = this.verID;
        this.framesize = (j / (localObject[i][this.sampling_frequency] << paramInt));
        this.framesize += this.padding;
        paramInt = 17;
        if (i == 3)
        {
          if (this.mode != 3) {
            paramInt = 32;
          }
          this.sideinfosize = paramInt;
          return;
        }
        if (this.mode == 3) {
          paramInt = 9;
        }
        this.sideinfosize = paramInt;
        return;
      }
      this.framesize = (this.bitrate[this.lsf][1][this.bitrate_index] * 144000);
      this.framesize /= this.samplingRate[this.verID][this.sampling_frequency];
      this.framesize += this.padding;
      return;
    }
    this.framesize = (this.bitrate[this.lsf][0][this.bitrate_index] * 12000);
    this.framesize /= this.samplingRate[this.verID][this.sampling_frequency];
    this.framesize += this.padding;
    this.framesize <<= 2;
  }
  
  public int getFrameSize()
  {
    return this.framesize;
  }
  
  protected void initialize()
  {
    this.framesize = 0;
    this.sideinfosize = 0;
    this.layer = 0;
    this.verID = 1;
  }
  
  public boolean isProtected()
  {
    return this.protection_bit == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Header
 * JD-Core Version:    0.7.0.1
 */