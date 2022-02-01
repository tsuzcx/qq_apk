package com.tencent.tkd.topicsdk.covergallery;

import com.tencent.tkd.topicsdk.bean.Media;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "position", "", "invoke"}, k=3, mv={1, 1, 16})
final class CoverGalleryView$initView$2
  extends Lambda
  implements Function1<Integer, Unit>
{
  CoverGalleryView$initView$2(CoverGalleryView paramCoverGalleryView)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    CoverGalleryView.b(this.this$0);
    CoverGalleryView.a(this.this$0, (Media)CoverGalleryView.a(this.this$0).get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.covergallery.CoverGalleryView.initView.2
 * JD-Core Version:    0.7.0.1
 */