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

public class qjy
{
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk != null)) {}
    try
    {
      Object localObject;
      switch (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Int)
      {
      case 1: 
        paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int = 1;
        paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qma.jdField_b_of_type_JavaLangString;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) {
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean = true;
        }
        try
        {
          paramBaseArticleInfo.mSinglePicture = new URL(((articlesummary.PGCPicInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qma.jdField_a_of_type_JavaUtilArrayList.get(0)).bytes_pic_url.get().toStringUtf8());
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
        paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qmt.g;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null)
        {
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean = true;
          localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qmt;
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.b = new ArrayList();
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.b.add(localObject);
          try
          {
            paramBaseArticleInfo.mSinglePicture = new URL(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qmt.d);
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
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null)
        {
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean = true;
          if ((paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qma != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qma.jdField_a_of_type_JavaUtilArrayList != null))
          {
            paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qma.jdField_b_of_type_JavaLangString;
            paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qma.jdField_a_of_type_JavaUtilArrayList.iterator();
          }
        }
        break;
      case 2: 
      case 5: 
        while (((Iterator)localObject).hasNext())
        {
          articlesummary.PGCPicInfo localPGCPicInfo = (articlesummary.PGCPicInfo)((Iterator)localObject).next();
          qms localqms = new qms();
          localqms.jdField_b_of_type_JavaLangString = localPGCPicInfo.bytes_pic_url.get().toStringUtf8();
          localqms.jdField_c_of_type_JavaLangString = localPGCPicInfo.bytes_thumbnail_url.get().toStringUtf8();
          localqms.jdField_a_of_type_Int = localPGCPicInfo.uint32_pic_width.get();
          localqms.jdField_b_of_type_Int = localPGCPicInfo.uint32_pic_height.get();
          localqms.jdField_a_of_type_JavaLangString = localPGCPicInfo.bytes_pic_md5.get().toStringUtf8();
          localqms.jdField_c_of_type_Int = localPGCPicInfo.is_animation.get();
          localqms.d = localPGCPicInfo.bytes_pic_desc.get().toStringUtf8();
          localqms.jdField_a_of_type_Long = localPGCPicInfo.uint64_gallery_index.get();
          localqms.jdField_a_of_type_Qmt = new qmt((articlesummary.PGCVideoInfo)localPGCPicInfo.msg_video_info.get());
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList.add(localqms);
          continue;
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int = 6;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) {
            paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean = true;
          }
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qmt != null)
          {
            paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qmt.g;
            paramBaseArticleInfo.mVideoVid = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qmt.e;
          }
          try
          {
            paramBaseArticleInfo.mVideoCoverUrl = new URL(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qmt.d);
            return;
          }
          catch (MalformedURLException paramBaseArticleInfo)
          {
            paramBaseArticleInfo.printStackTrace();
            return;
          }
          paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int = 19191924;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) {
            paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean = true;
          }
          paramBaseArticleInfo.mTitle = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmk.jdField_a_of_type_Qmq.jdField_a_of_type_JavaLangString;
          return;
        }
      }
      return;
    }
    catch (NullPointerException paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qjy
 * JD-Core Version:    0.7.0.1
 */