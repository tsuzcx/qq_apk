package dov.com.qq.im.ae.gif;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import dov.com.qq.im.ae.data.AEMaterialWrapper;
import dov.com.qq.im.ae.download.AEDownloadStateWrapper;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFStickerAdapter;
import java.util.Iterator;
import java.util.List;

class AEGIFStickerListPart$5
  implements Observer<AEDownloadStateWrapper>
{
  AEGIFStickerListPart$5(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void a(@Nullable AEDownloadStateWrapper paramAEDownloadStateWrapper)
  {
    label4:
    Object localObject1;
    Object localObject2;
    if (paramAEDownloadStateWrapper == null)
    {
      return;
    }
    else
    {
      boolean bool = AEGIFStickerListPart.a(this.a);
      if (bool) {
        AEGIFStickerListPart.a(this.a, null);
      }
      localObject1 = AEGIFStickerListPart.a(this.a).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AEMaterialWrapper)((Iterator)localObject1).next();
        if (((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString.equals(paramAEDownloadStateWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id))
        {
          if (((AEMaterialWrapper)localObject2).jdField_a_of_type_Int != paramAEDownloadStateWrapper.jdField_a_of_type_Int)
          {
            ((AEMaterialWrapper)localObject2).jdField_a_of_type_Int = paramAEDownloadStateWrapper.jdField_a_of_type_Int;
            AEGIFStickerListPart.a(this.a).a((AEMaterialWrapper)localObject2, bool);
          }
          if ((((AEMaterialWrapper)localObject2).jdField_a_of_type_Int == 2) && (((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString.equals(AEGIFStickerListPart.b(this.a))) && (!bool)) {
            AEGIFStickerListPart.a(this.a).b((AEMaterialWrapper)localObject2);
          }
        }
      }
      localObject2 = AEGIFStickerListPart.b(this.a).iterator();
    }
    label293:
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label4;
      }
      localObject1 = (AEGifCategoryWrapper)((Iterator)localObject2).next();
      if ((localObject1 == null) || (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList))) {
        break;
      }
      Iterator localIterator = ((AEGifCategoryWrapper)localObject1).materialWrapperList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (AEMaterialWrapper)localIterator.next();
      } while ((localObject1 == null) || (TextUtils.isEmpty(((AEMaterialWrapper)localObject1).jdField_a_of_type_JavaLangString)) || (!((AEMaterialWrapper)localObject1).jdField_a_of_type_JavaLangString.equals(paramAEDownloadStateWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id)));
      for (;;)
      {
        if (localObject1 == null) {
          break label293;
        }
        if (((AEMaterialWrapper)localObject1).jdField_a_of_type_Int == paramAEDownloadStateWrapper.jdField_a_of_type_Int) {
          break;
        }
        ((AEMaterialWrapper)localObject1).jdField_a_of_type_Int = paramAEDownloadStateWrapper.jdField_a_of_type_Int;
        return;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEGIFStickerListPart.5
 * JD-Core Version:    0.7.0.1
 */