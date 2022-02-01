package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_sbcs$NGramParser
{
  private static final int N_GRAM_MASK = 16777215;
  protected int byteIndex = 0;
  protected byte[] byteMap;
  private int hitCount;
  private int ngram = 0;
  private int ngramCount;
  private int[] ngramList;
  protected byte spaceChar;
  
  public CharsetRecog_sbcs$NGramParser(int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    this.ngramList = paramArrayOfInt;
    this.byteMap = paramArrayOfByte;
    this.ngram = 0;
    this.hitCount = 0;
    this.ngramCount = 0;
  }
  
  private void lookup(int paramInt)
  {
    this.ngramCount += 1;
    if (search(this.ngramList, paramInt) >= 0) {
      this.hitCount += 1;
    }
  }
  
  private int nextByte(CharsetDetector paramCharsetDetector)
  {
    if (this.byteIndex >= paramCharsetDetector.fInputLen) {
      return -1;
    }
    paramCharsetDetector = paramCharsetDetector.fInputBytes;
    int i = this.byteIndex;
    this.byteIndex = (i + 1);
    return paramCharsetDetector[i] & 0xFF;
  }
  
  private static int search(int[] paramArrayOfInt, int paramInt)
  {
    int i = 32;
    if (paramArrayOfInt[32] > paramInt) {
      i = 0;
    }
    int j = i + 16;
    if (paramArrayOfInt[j] <= paramInt) {
      i = j;
    }
    j = i + 8;
    if (paramArrayOfInt[j] <= paramInt) {
      i = j;
    }
    j = i + 4;
    if (paramArrayOfInt[j] <= paramInt) {
      i = j;
    }
    j = i + 2;
    if (paramArrayOfInt[j] <= paramInt) {
      i = j;
    }
    j = i + 1;
    if (paramArrayOfInt[j] <= paramInt) {
      i = j;
    }
    j = i;
    if (paramArrayOfInt[i] > paramInt) {
      j = i - 1;
    }
    if ((j >= 0) && (paramArrayOfInt[j] == paramInt)) {
      return j;
    }
    return -1;
  }
  
  protected void addByte(int paramInt)
  {
    this.ngram = (0xFFFFFF & (this.ngram << 8) + (paramInt & 0xFF));
    lookup(this.ngram);
  }
  
  public int parse(CharsetDetector paramCharsetDetector)
  {
    return parse(paramCharsetDetector, (byte)32);
  }
  
  public int parse(CharsetDetector paramCharsetDetector, byte paramByte)
  {
    this.spaceChar = paramByte;
    parseCharacters(paramCharsetDetector);
    addByte(this.spaceChar);
    double d1 = this.hitCount;
    double d2 = this.ngramCount;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    if (d1 > 0.33D) {
      return 98;
    }
    return (int)(d1 * 300.0D);
  }
  
  protected void parseCharacters(CharsetDetector paramCharsetDetector)
  {
    int i = 0;
    for (;;)
    {
      int j = nextByte(paramCharsetDetector);
      if (j < 0) {
        return;
      }
      j = this.byteMap[j];
      if (j != 0)
      {
        if ((j != this.spaceChar) || (i == 0)) {
          addByte(j);
        }
        if (j != this.spaceChar) {
          break;
        }
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.NGramParser
 * JD-Core Version:    0.7.0.1
 */