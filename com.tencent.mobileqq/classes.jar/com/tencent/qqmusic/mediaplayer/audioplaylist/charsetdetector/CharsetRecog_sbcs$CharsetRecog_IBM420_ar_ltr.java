package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_sbcs$CharsetRecog_IBM420_ar_ltr
  extends CharsetRecog_sbcs.CharsetRecog_IBM420_ar
{
  private static int[] ngrams = { 4212310, 4216507, 4216511, 4219507, 4219509, 4219569, 4219579, 4219612, 4219734, 4224342, 4224476, 4239702, 4242262, 4242774, 4242875, 4242895, 4242908, 4250289, 4250795, 4250801, 4829526, 5652566, 5652568, 5652578, 5652579, 5652595, 5652597, 5652600, 5652634, 5652657, 5652667, 5652669, 5652671, 5652698, 5652700, 5658688, 5681494, 5689152, 5812566, 6533462, 6536534, 6795606, 6926678, 7582038, 7909718, 10137942, 11223138, 11383126, 11616354, 11621952, 11622095, 11639360, 11645248, 12271714, 12271836, 12300630, 12408384, 12434240, 13582434, 13582556, 13611350, 14332314, 14461760, 14463318 };
  
  public String getName()
  {
    return "IBM420_ltr";
  }
  
  public CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    int i = matchIBM420(paramCharsetDetector, ngrams, byteMap, (byte)64);
    if (i == 0) {
      return null;
    }
    return new CharsetMatch(paramCharsetDetector, this, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.CharsetRecog_IBM420_ar_ltr
 * JD-Core Version:    0.7.0.1
 */