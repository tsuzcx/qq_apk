import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.GalleryPGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;

public class qyg
{
  public int a;
  public String a;
  public ArrayList<qyh> a;
  public qxu a;
  public boolean a;
  public int b;
  public ArrayList<qyi> b;
  public int c;
  
  public qyg()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    qyh localqyh;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localqyh.toString() + "},") {
      localqyh = (qyh)localIterator.next();
    }
    return str + "]";
  }
  
  public static articlesummary.PGCFeedsInfo a(qyg paramqyg)
  {
    articlesummary.PGCFeedsInfo localPGCFeedsInfo = new articlesummary.PGCFeedsInfo();
    qfm.a(localPGCFeedsInfo.bytes_pgc_comments, paramqyg.jdField_a_of_type_JavaLangString);
    if (paramqyg.jdField_a_of_type_Boolean) {
      localPGCFeedsInfo.uint32_article_type.set(1);
    }
    qfm.a(localPGCFeedsInfo.uint32_myself_follow_status, paramqyg.jdField_b_of_type_Int);
    qfm.a(localPGCFeedsInfo.uint32_follow_counts, paramqyg.jdField_a_of_type_Int);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (a(paramqyg.jdField_a_of_type_JavaUtilArrayList))
    {
      localObject1 = new ArrayList();
      localObject2 = paramqyg.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (qyh)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCPicInfo();
        qfm.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((qyh)localObject3).jdField_a_of_type_JavaLangString);
        qfm.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((qyh)localObject3).jdField_b_of_type_JavaLangString);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_height.set(((qyh)localObject3).jdField_b_of_type_Int);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_width.set(((qyh)localObject3).jdField_a_of_type_Int);
        qfm.a(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((qyh)localObject3).jdField_c_of_type_JavaLangString);
        qfm.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((qyh)localObject3).d);
        qfm.a(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((qyh)localObject3).jdField_a_of_type_Long);
        if (((qyh)localObject3).jdField_a_of_type_Qyi != null)
        {
          articlesummary.PGCVideoInfo localPGCVideoInfo = new articlesummary.PGCVideoInfo();
          qfm.a(localPGCVideoInfo.bytes_vid, ((qyh)localObject3).jdField_a_of_type_Qyi.e);
          qfm.a(localPGCVideoInfo.bytes_video_url, ((qyh)localObject3).jdField_a_of_type_Qyi.jdField_b_of_type_JavaLangString);
          qfm.a(localPGCVideoInfo.bytes_video_md5, ((qyh)localObject3).jdField_a_of_type_Qyi.jdField_a_of_type_JavaLangString);
          qfm.a(localPGCVideoInfo.bytes_pic_md5, ((qyh)localObject3).jdField_a_of_type_Qyi.jdField_c_of_type_JavaLangString);
          qfm.a(localPGCVideoInfo.bytes_pic_url, ((qyh)localObject3).jdField_a_of_type_Qyi.d);
          localPGCVideoInfo.uint32_duration.set(((qyh)localObject3).jdField_a_of_type_Qyi.jdField_a_of_type_Int);
          localPGCVideoInfo.uint32_busi_type.set(((qyh)localObject3).jdField_a_of_type_Qyi.jdField_b_of_type_Int);
          ((articlesummary.PGCPicInfo)localObject4).msg_video_info.set(localPGCVideoInfo);
        }
        ((articlesummary.PGCPicInfo)localObject4).is_animation.set(((qyh)localObject3).jdField_c_of_type_Int);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_pic_info_list.set((List)localObject1);
    }
    if (b(paramqyg.jdField_b_of_type_JavaUtilArrayList))
    {
      localObject1 = new ArrayList();
      localObject2 = paramqyg.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (qyi)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCVideoInfo();
        qfm.a(((articlesummary.PGCVideoInfo)localObject4).bytes_video_url, ((qyi)localObject3).jdField_b_of_type_JavaLangString);
        qfm.a(((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5, ((qyi)localObject3).jdField_a_of_type_JavaLangString);
        qfm.a(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5, ((qyi)localObject3).jdField_c_of_type_JavaLangString);
        qfm.a(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url, ((qyi)localObject3).d);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_video_info_list.set((List)localObject1);
    }
    localPGCFeedsInfo.enum_pgc_feeds_type.set(paramqyg.jdField_c_of_type_Int);
    if (paramqyg.jdField_a_of_type_Qxu != null)
    {
      localObject1 = new articlesummary.GalleryPGCFeedsInfo();
      qfm.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_pic_count, paramqyg.jdField_a_of_type_Qxu.jdField_a_of_type_Long);
      qfm.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_source, paramqyg.jdField_a_of_type_Qxu.b);
      qfm.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_sub_source, paramqyg.jdField_a_of_type_Qxu.c);
      qfm.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).bytes_gallery_url, paramqyg.jdField_a_of_type_Qxu.jdField_a_of_type_JavaLangString);
      if (a(paramqyg.jdField_a_of_type_Qxu.jdField_a_of_type_JavaUtilArrayList))
      {
        localObject2 = new ArrayList();
        paramqyg = paramqyg.jdField_a_of_type_Qxu.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramqyg.hasNext())
        {
          localObject3 = (qyh)paramqyg.next();
          localObject4 = new articlesummary.PGCPicInfo();
          qfm.a(((articlesummary.PGCPicInfo)localObject4).uint32_pic_width, ((qyh)localObject3).jdField_a_of_type_Int);
          qfm.a(((articlesummary.PGCPicInfo)localObject4).uint32_pic_height, ((qyh)localObject3).jdField_b_of_type_Int);
          qfm.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((qyh)localObject3).jdField_a_of_type_JavaLangString);
          qfm.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((qyh)localObject3).jdField_b_of_type_JavaLangString);
          qfm.a(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((qyh)localObject3).jdField_c_of_type_JavaLangString);
          qfm.a(((articlesummary.PGCPicInfo)localObject4).is_animation, ((qyh)localObject3).jdField_c_of_type_Int);
          qfm.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((qyh)localObject3).d);
          qfm.a(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((qyh)localObject3).jdField_a_of_type_Long);
          ((List)localObject2).add(localObject4);
        }
      }
      localPGCFeedsInfo.msg_gallery_feeds_info.set((MessageMicro)localObject1);
    }
    return localPGCFeedsInfo;
  }
  
  private static boolean a(List<qyh> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  private String b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    qyi localqyi;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localqyi.toString() + "},") {
      localqyi = (qyi)localIterator.next();
    }
    return str + "]";
  }
  
  private static qyg b(articlesummary.PGCFeedsInfo paramPGCFeedsInfo)
  {
    qyg localqyg = new qyg();
    if (paramPGCFeedsInfo.bytes_pgc_comments.has()) {
      localqyg.jdField_a_of_type_JavaLangString = paramPGCFeedsInfo.bytes_pgc_comments.get().toStringUtf8();
    }
    if (paramPGCFeedsInfo.uint32_myself_follow_status.has()) {
      localqyg.jdField_b_of_type_Int = paramPGCFeedsInfo.uint32_myself_follow_status.get();
    }
    if (paramPGCFeedsInfo.uint32_follow_counts.has()) {
      localqyg.jdField_a_of_type_Int = paramPGCFeedsInfo.uint32_follow_counts.get();
    }
    if (paramPGCFeedsInfo.uint32_article_type.has()) {
      localqyg.jdField_a_of_type_Boolean = true;
    }
    Iterator localIterator;
    Object localObject1;
    qyi localqyi;
    if (paramPGCFeedsInfo.msg_pgc_pic_info_list.has())
    {
      localIterator = paramPGCFeedsInfo.msg_pgc_pic_info_list.get().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (articlesummary.PGCPicInfo)localIterator.next();
        localObject1 = new qyh();
        if (((articlesummary.PGCPicInfo)localObject2).bytes_pic_md5.has()) {
          ((qyh)localObject1).jdField_a_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).bytes_pic_url.has()) {
          ((qyh)localObject1).jdField_b_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).uint32_pic_height.has()) {
          ((qyh)localObject1).jdField_b_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).uint32_pic_height.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).uint32_pic_width.has()) {
          ((qyh)localObject1).jdField_a_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).uint32_pic_width.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).is_animation.has()) {
          ((qyh)localObject1).jdField_c_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).is_animation.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).bytes_thumbnail_url.has()) {
          ((qyh)localObject1).jdField_c_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_thumbnail_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).bytes_pic_desc.has()) {
          ((qyh)localObject1).d = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_desc.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).uint64_gallery_index.has()) {
          ((qyh)localObject1).jdField_a_of_type_Long = ((articlesummary.PGCPicInfo)localObject2).uint64_gallery_index.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).msg_video_info.has())
        {
          localqyi = new qyi();
          localObject2 = (articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject2).msg_video_info.get();
          if (((articlesummary.PGCVideoInfo)localObject2).bytes_pic_md5.has()) {
            localqyi.jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject2).bytes_pic_md5.get().toStringUtf8();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).bytes_pic_url.has()) {
            localqyi.d = ((articlesummary.PGCVideoInfo)localObject2).bytes_pic_url.get().toStringUtf8();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).bytes_vid.has()) {
            localqyi.e = ((articlesummary.PGCVideoInfo)localObject2).bytes_vid.get().toStringUtf8();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).uint32_duration.has()) {
            localqyi.jdField_a_of_type_Int = ((articlesummary.PGCVideoInfo)localObject2).uint32_duration.get();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).uint32_busi_type.has()) {
            localqyi.jdField_b_of_type_Int = ((articlesummary.PGCVideoInfo)localObject2).uint32_busi_type.get();
          }
          ((qyh)localObject1).jdField_a_of_type_Qyi = localqyi;
        }
        localqyg.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
    if (paramPGCFeedsInfo.msg_pgc_video_info_list.has())
    {
      localIterator = paramPGCFeedsInfo.msg_pgc_video_info_list.get().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (articlesummary.PGCVideoInfo)localIterator.next();
        localqyi = new qyi();
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_pic_md5.has()) {
          localqyi.jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject1).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_pic_url.has()) {
          localqyi.d = ((articlesummary.PGCVideoInfo)localObject1).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_video_md5.has()) {
          localqyi.jdField_a_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject1).bytes_video_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_video_url.has()) {
          localqyi.jdField_b_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject1).bytes_video_url.get().toStringUtf8();
        }
        localqyg.jdField_b_of_type_JavaUtilArrayList.add(localqyi);
      }
    }
    if (paramPGCFeedsInfo.msg_gallery_feeds_info.has())
    {
      localqyg.jdField_a_of_type_Qxu = new qxu();
      paramPGCFeedsInfo = (articlesummary.GalleryPGCFeedsInfo)paramPGCFeedsInfo.msg_gallery_feeds_info.get();
      if (paramPGCFeedsInfo.uint64_pic_count.has()) {
        localqyg.jdField_a_of_type_Qxu.jdField_a_of_type_Long = paramPGCFeedsInfo.uint64_pic_count.get();
      }
    }
    return localqyg;
  }
  
  private static boolean b(List<qyi> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  public String toString()
  {
    return "PGCFeedsInfo{pGCPicInfos=" + a() + ", pGCVideoInfos=" + b() + ", pgcComments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", followCount=" + this.jdField_a_of_type_Int + ", followStatus=" + this.jdField_b_of_type_Int + ", isShortContent=" + this.jdField_a_of_type_Boolean + ", pgcFeedsType=" + this.jdField_c_of_type_Int + ", galleryPGCFeedsInfo=" + this.jdField_a_of_type_Qxu + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyg
 * JD-Core Version:    0.7.0.1
 */