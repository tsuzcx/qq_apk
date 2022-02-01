package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.interfaces.IImageLoader.ImageLoaderOption;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ImageLoaderImpl$loadImageFromFile$runnable$1
  implements Runnable
{
  ImageLoaderImpl$loadImageFromFile$runnable$1(ImageLoaderImpl paramImageLoaderImpl, IImageLoader.ImageLoaderOption paramImageLoaderOption, ImageView paramImageView, String paramString1, String paramString2) {}
  
  public final void run()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader$ImageLoaderOption.a > 0)
    {
      i = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader$ImageLoaderOption.a;
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader$ImageLoaderOption.a <= 0) {
        break label141;
      }
    }
    label141:
    for (int j = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader$ImageLoaderOption.b;; j = this.jdField_a_of_type_AndroidWidgetImageView.getHeight())
    {
      Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
      localObjectRef.element = ImageLoaderImpl.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      if ((Bitmap)localObjectRef.element == null) {
        localObjectRef.element = ImageLoaderImpl.a(this.this$0, this.b, i, j);
      }
      if ((Bitmap)localObjectRef.element == null) {
        break label152;
      }
      ImageLoaderImpl.a(this.this$0, this.jdField_a_of_type_JavaLangString, (Bitmap)localObjectRef.element);
      ThreadManagerKt.a((Function0)new ImageLoaderImpl.loadImageFromFile.runnable.1.1(this, localObjectRef));
      return;
      i = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      break;
    }
    label152:
    QLog.e("ImageLoaderImpl", 1, "loadImageFromFile error. bitmap is null.");
    ThreadManagerKt.a((Function0)new ImageLoaderImpl.loadImageFromFile.runnable.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ImageLoaderImpl.loadImageFromFile.runnable.1
 * JD-Core Version:    0.7.0.1
 */