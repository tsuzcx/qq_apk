import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdaterShortContent;", "Lcom/tencent/biz/pubaccount/readinjoy/srtUtils/longcontentinfoupdater/LongContentInfoUpdater;", "()V", "process", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class roi
  extends roe
{
  protected void a()
  {
    rrm localrrm = null;
    Object localObject1 = a();
    if (localObject1 != null) {
      ((SocializeFeedsInfo)localObject1).jdField_a_of_type_Int = 3;
    }
    rrl localrrl = a();
    if (localrrl != null)
    {
      localrrl.jdField_a_of_type_Boolean = true;
      localObject1 = a();
      if (localObject1 != null)
      {
        localObject1 = ((rre)localObject1).a;
        if (localObject1 == null) {
          return;
        }
        localObject1 = a();
        if (localObject1 == null) {
          break label352;
        }
        localObject1 = ((rre)localObject1).a;
        if (localObject1 == null) {
          break label352;
        }
      }
      label352:
      for (localObject1 = ((rqu)localObject1).jdField_a_of_type_JavaUtilArrayList;; localObject1 = null)
      {
        if (localObject1 == null) {
          return;
        }
        Object localObject2 = a();
        Object localObject3 = a();
        localObject1 = localrrm;
        if (localObject3 != null)
        {
          localObject3 = ((rre)localObject3).a;
          localObject1 = localrrm;
          if (localObject3 != null) {
            localObject1 = ((rqu)localObject3).jdField_b_of_type_JavaLangString;
          }
        }
        ((BaseArticleInfo)localObject2).mTitle = ((String)localObject1);
        localrrl.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject1 = a();
        if (localObject1 == null) {
          return;
        }
        localObject1 = ((rre)localObject1).a;
        if (localObject1 == null) {
          return;
        }
        localObject1 = ((rqu)localObject1).jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 == null) {
          return;
        }
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (articlesummary.PGCPicInfo)((Iterator)localObject1).next();
          localrrm = new rrm();
          localrrm.jdField_b_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_url.get().toStringUtf8();
          localrrm.jdField_c_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_thumbnail_url.get().toStringUtf8();
          localrrm.jdField_a_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).uint32_pic_width.get();
          localrrm.jdField_b_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).uint32_pic_height.get();
          localrrm.jdField_a_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_md5.get().toStringUtf8();
          localrrm.jdField_c_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).is_animation.get();
          localrrm.d = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_desc.get().toStringUtf8();
          localrrm.jdField_a_of_type_Long = ((articlesummary.PGCPicInfo)localObject2).uint64_gallery_index.get();
          localrrm.jdField_a_of_type_Rrn = new rrn((articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject2).msg_video_info.get());
          localObject2 = localrrl.jdField_a_of_type_JavaUtilArrayList;
          if (localObject2 != null) {
            ((ArrayList)localObject2).add(localrrm);
          }
        }
        localObject1 = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     roi
 * JD-Core Version:    0.7.0.1
 */