package com.tencent.tavcut.render.audio.extractor;

import com.tencent.tav.core.audio.ExportCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "status", "", "progress", "", "onProgress"}, k=3, mv={1, 1, 16})
final class TavAudioExtractor$startExtract$1
  implements ExportCallback
{
  TavAudioExtractor$startExtract$1(TavAudioExtractor paramTavAudioExtractor, String paramString) {}
  
  public final void onProgress(int paramInt, float paramFloat)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 255) {
          return;
        }
        localObject = TavAudioExtractor.a(this.a);
        if (localObject != null) {
          ((OnAudioExtractorListener)localObject).a(2, "Extractor audio fail");
        }
        TavAudioExtractor.a(this.a, (OnAudioExtractorListener)null);
        return;
      }
      localObject = TavAudioExtractor.a(this.a);
      if (localObject != null) {
        ((OnAudioExtractorListener)localObject).a(100);
      }
      localObject = TavAudioExtractor.a(this.a);
      if (localObject != null) {
        ((OnAudioExtractorListener)localObject).a(this.b);
      }
      TavAudioExtractor.a(this.a, (OnAudioExtractorListener)null);
      return;
    }
    Object localObject = this.a;
    TavAudioExtractor.a((TavAudioExtractor)localObject, paramFloat, TavAudioExtractor.a((TavAudioExtractor)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.extractor.TavAudioExtractor.startExtract.1
 * JD-Core Version:    0.7.0.1
 */