import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class qad
{
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco != null)) {}
    try
    {
      Object localObject;
      switch (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Int)
      {
      case 1: 
        paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int = 1;
        paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qce.jdField_b_of_type_JavaLangString;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) {
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Boolean = true;
        }
        try
        {
          paramBaseArticleInfo.mSinglePicture = new URL(((articlesummary.PGCPicInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qce.jdField_a_of_type_JavaUtilArrayList.get(0)).bytes_pic_url.get().toStringUtf8());
          return;
        }
        catch (MalformedURLException paramBaseArticleInfo)
        {
          paramBaseArticleInfo.printStackTrace();
          return;
        }
        catch (IndexOutOfBoundsException paramBaseArticleInfo)
        {
          paramBaseArticleInfo.printStackTrace();
          return;
        }
      case 3: 
        paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int = 1;
        paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcx.g;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null)
        {
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Boolean = true;
          localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcx;
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.b = new ArrayList();
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.b.add(localObject);
          try
          {
            paramBaseArticleInfo.mSinglePicture = new URL(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcx.d);
            return;
          }
          catch (MalformedURLException paramBaseArticleInfo)
          {
            paramBaseArticleInfo.printStackTrace();
            return;
          }
        }
        break;
      case 4: 
        paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int = 3;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null)
        {
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Boolean = true;
          if ((paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qce != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qce.jdField_a_of_type_JavaUtilArrayList != null))
          {
            paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qce.jdField_b_of_type_JavaLangString;
            paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qce.jdField_a_of_type_JavaUtilArrayList.iterator();
          }
        }
        break;
      case 2: 
      case 5: 
        while (((Iterator)localObject).hasNext())
        {
          articlesummary.PGCPicInfo localPGCPicInfo = (articlesummary.PGCPicInfo)((Iterator)localObject).next();
          qcw localqcw = new qcw();
          localqcw.jdField_b_of_type_JavaLangString = localPGCPicInfo.bytes_pic_url.get().toStringUtf8();
          localqcw.jdField_c_of_type_JavaLangString = localPGCPicInfo.bytes_thumbnail_url.get().toStringUtf8();
          localqcw.jdField_a_of_type_Int = localPGCPicInfo.uint32_pic_width.get();
          localqcw.jdField_b_of_type_Int = localPGCPicInfo.uint32_pic_height.get();
          localqcw.jdField_a_of_type_JavaLangString = localPGCPicInfo.bytes_pic_md5.get().toStringUtf8();
          localqcw.jdField_c_of_type_Int = localPGCPicInfo.is_animation.get();
          localqcw.d = localPGCPicInfo.bytes_pic_desc.get().toStringUtf8();
          localqcw.jdField_a_of_type_Long = localPGCPicInfo.uint64_gallery_index.get();
          localqcw.jdField_a_of_type_Qcx = new qcx((articlesummary.PGCVideoInfo)localPGCPicInfo.msg_video_info.get());
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.add(localqcw);
          continue;
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int = 6;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) {
            paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Boolean = true;
          }
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcx != null)
          {
            paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcx.g;
            paramBaseArticleInfo.mVideoVid = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcx.e;
          }
          try
          {
            paramBaseArticleInfo.mVideoCoverUrl = new URL(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcx.d);
            return;
          }
          catch (MalformedURLException paramBaseArticleInfo)
          {
            paramBaseArticleInfo.printStackTrace();
            return;
          }
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int = 19191924;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) {
            paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Boolean = true;
          }
          paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.jdField_a_of_type_Qcu.jdField_a_of_type_JavaLangString;
          return;
        }
      }
      return;
    }
    catch (NullPointerException paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qad
 * JD-Core Version:    0.7.0.1
 */