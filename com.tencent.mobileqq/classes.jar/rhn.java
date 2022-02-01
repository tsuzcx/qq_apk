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

public class rhn
{
  public int a;
  public String a;
  public ArrayList<rho> a;
  public rhb a;
  public boolean a;
  public int b;
  public ArrayList<rhp> b;
  public int c;
  
  public rhn()
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
    rho localrho;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localrho.toString() + "},") {
      localrho = (rho)localIterator.next();
    }
    return str + "]";
  }
  
  public static articlesummary.PGCFeedsInfo a(rhn paramrhn)
  {
    articlesummary.PGCFeedsInfo localPGCFeedsInfo = new articlesummary.PGCFeedsInfo();
    qnb.a(localPGCFeedsInfo.bytes_pgc_comments, paramrhn.jdField_a_of_type_JavaLangString);
    if (paramrhn.jdField_a_of_type_Boolean) {
      localPGCFeedsInfo.uint32_article_type.set(1);
    }
    qnb.a(localPGCFeedsInfo.uint32_myself_follow_status, paramrhn.jdField_b_of_type_Int);
    qnb.a(localPGCFeedsInfo.uint32_follow_counts, paramrhn.jdField_a_of_type_Int);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (a(paramrhn.jdField_a_of_type_JavaUtilArrayList))
    {
      localObject1 = new ArrayList();
      localObject2 = paramrhn.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (rho)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCPicInfo();
        qnb.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((rho)localObject3).jdField_a_of_type_JavaLangString);
        qnb.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((rho)localObject3).jdField_b_of_type_JavaLangString);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_height.set(((rho)localObject3).jdField_b_of_type_Int);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_width.set(((rho)localObject3).jdField_a_of_type_Int);
        qnb.a(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((rho)localObject3).jdField_c_of_type_JavaLangString);
        qnb.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((rho)localObject3).d);
        qnb.a(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((rho)localObject3).jdField_a_of_type_Long);
        if (((rho)localObject3).jdField_a_of_type_Rhp != null)
        {
          articlesummary.PGCVideoInfo localPGCVideoInfo = new articlesummary.PGCVideoInfo();
          qnb.a(localPGCVideoInfo.bytes_vid, ((rho)localObject3).jdField_a_of_type_Rhp.e);
          qnb.a(localPGCVideoInfo.bytes_video_url, ((rho)localObject3).jdField_a_of_type_Rhp.jdField_b_of_type_JavaLangString);
          qnb.a(localPGCVideoInfo.bytes_video_md5, ((rho)localObject3).jdField_a_of_type_Rhp.jdField_a_of_type_JavaLangString);
          qnb.a(localPGCVideoInfo.bytes_pic_md5, ((rho)localObject3).jdField_a_of_type_Rhp.jdField_c_of_type_JavaLangString);
          qnb.a(localPGCVideoInfo.bytes_pic_url, ((rho)localObject3).jdField_a_of_type_Rhp.d);
          localPGCVideoInfo.uint32_duration.set(((rho)localObject3).jdField_a_of_type_Rhp.jdField_a_of_type_Int);
          localPGCVideoInfo.uint32_busi_type.set(((rho)localObject3).jdField_a_of_type_Rhp.jdField_b_of_type_Int);
          ((articlesummary.PGCPicInfo)localObject4).msg_video_info.set(localPGCVideoInfo);
        }
        ((articlesummary.PGCPicInfo)localObject4).is_animation.set(((rho)localObject3).jdField_c_of_type_Int);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_pic_info_list.set((List)localObject1);
    }
    if (b(paramrhn.jdField_b_of_type_JavaUtilArrayList))
    {
      localObject1 = new ArrayList();
      localObject2 = paramrhn.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (rhp)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCVideoInfo();
        qnb.a(((articlesummary.PGCVideoInfo)localObject4).bytes_video_url, ((rhp)localObject3).jdField_b_of_type_JavaLangString);
        qnb.a(((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5, ((rhp)localObject3).jdField_a_of_type_JavaLangString);
        qnb.a(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5, ((rhp)localObject3).jdField_c_of_type_JavaLangString);
        qnb.a(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url, ((rhp)localObject3).d);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_video_info_list.set((List)localObject1);
    }
    localPGCFeedsInfo.enum_pgc_feeds_type.set(paramrhn.jdField_c_of_type_Int);
    if (paramrhn.jdField_a_of_type_Rhb != null)
    {
      localObject1 = new articlesummary.GalleryPGCFeedsInfo();
      qnb.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_pic_count, paramrhn.jdField_a_of_type_Rhb.jdField_a_of_type_Long);
      qnb.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_source, paramrhn.jdField_a_of_type_Rhb.b);
      qnb.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_sub_source, paramrhn.jdField_a_of_type_Rhb.c);
      qnb.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).bytes_gallery_url, paramrhn.jdField_a_of_type_Rhb.jdField_a_of_type_JavaLangString);
      if (a(paramrhn.jdField_a_of_type_Rhb.jdField_a_of_type_JavaUtilArrayList))
      {
        localObject2 = new ArrayList();
        paramrhn = paramrhn.jdField_a_of_type_Rhb.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramrhn.hasNext())
        {
          localObject3 = (rho)paramrhn.next();
          localObject4 = new articlesummary.PGCPicInfo();
          qnb.a(((articlesummary.PGCPicInfo)localObject4).uint32_pic_width, ((rho)localObject3).jdField_a_of_type_Int);
          qnb.a(((articlesummary.PGCPicInfo)localObject4).uint32_pic_height, ((rho)localObject3).jdField_b_of_type_Int);
          qnb.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((rho)localObject3).jdField_a_of_type_JavaLangString);
          qnb.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((rho)localObject3).jdField_b_of_type_JavaLangString);
          qnb.a(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((rho)localObject3).jdField_c_of_type_JavaLangString);
          qnb.a(((articlesummary.PGCPicInfo)localObject4).is_animation, ((rho)localObject3).jdField_c_of_type_Int);
          qnb.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((rho)localObject3).d);
          qnb.a(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((rho)localObject3).jdField_a_of_type_Long);
          ((List)localObject2).add(localObject4);
        }
      }
      localPGCFeedsInfo.msg_gallery_feeds_info.set((MessageMicro)localObject1);
    }
    return localPGCFeedsInfo;
  }
  
  private static boolean a(List<rho> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  private String b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    rhp localrhp;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localrhp.toString() + "},") {
      localrhp = (rhp)localIterator.next();
    }
    return str + "]";
  }
  
  private static rhn b(articlesummary.PGCFeedsInfo paramPGCFeedsInfo)
  {
    rhn localrhn = new rhn();
    if (paramPGCFeedsInfo.bytes_pgc_comments.has()) {
      localrhn.jdField_a_of_type_JavaLangString = paramPGCFeedsInfo.bytes_pgc_comments.get().toStringUtf8();
    }
    if (paramPGCFeedsInfo.uint32_myself_follow_status.has()) {
      localrhn.jdField_b_of_type_Int = paramPGCFeedsInfo.uint32_myself_follow_status.get();
    }
    if (paramPGCFeedsInfo.uint32_follow_counts.has()) {
      localrhn.jdField_a_of_type_Int = paramPGCFeedsInfo.uint32_follow_counts.get();
    }
    if (paramPGCFeedsInfo.uint32_article_type.has()) {
      localrhn.jdField_a_of_type_Boolean = true;
    }
    Iterator localIterator;
    Object localObject1;
    rhp localrhp;
    if (paramPGCFeedsInfo.msg_pgc_pic_info_list.has())
    {
      localIterator = paramPGCFeedsInfo.msg_pgc_pic_info_list.get().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (articlesummary.PGCPicInfo)localIterator.next();
        localObject1 = new rho();
        if (((articlesummary.PGCPicInfo)localObject2).bytes_pic_md5.has()) {
          ((rho)localObject1).jdField_a_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).bytes_pic_url.has()) {
          ((rho)localObject1).jdField_b_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).uint32_pic_height.has()) {
          ((rho)localObject1).jdField_b_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).uint32_pic_height.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).uint32_pic_width.has()) {
          ((rho)localObject1).jdField_a_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).uint32_pic_width.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).is_animation.has()) {
          ((rho)localObject1).jdField_c_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).is_animation.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).bytes_thumbnail_url.has()) {
          ((rho)localObject1).jdField_c_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_thumbnail_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).bytes_pic_desc.has()) {
          ((rho)localObject1).d = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_desc.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).uint64_gallery_index.has()) {
          ((rho)localObject1).jdField_a_of_type_Long = ((articlesummary.PGCPicInfo)localObject2).uint64_gallery_index.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).msg_video_info.has())
        {
          localrhp = new rhp();
          localObject2 = (articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject2).msg_video_info.get();
          if (((articlesummary.PGCVideoInfo)localObject2).bytes_pic_md5.has()) {
            localrhp.jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject2).bytes_pic_md5.get().toStringUtf8();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).bytes_pic_url.has()) {
            localrhp.d = ((articlesummary.PGCVideoInfo)localObject2).bytes_pic_url.get().toStringUtf8();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).bytes_vid.has()) {
            localrhp.e = ((articlesummary.PGCVideoInfo)localObject2).bytes_vid.get().toStringUtf8();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).uint32_duration.has()) {
            localrhp.jdField_a_of_type_Int = ((articlesummary.PGCVideoInfo)localObject2).uint32_duration.get();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).uint32_busi_type.has()) {
            localrhp.jdField_b_of_type_Int = ((articlesummary.PGCVideoInfo)localObject2).uint32_busi_type.get();
          }
          ((rho)localObject1).jdField_a_of_type_Rhp = localrhp;
        }
        localrhn.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
    if (paramPGCFeedsInfo.msg_pgc_video_info_list.has())
    {
      localIterator = paramPGCFeedsInfo.msg_pgc_video_info_list.get().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (articlesummary.PGCVideoInfo)localIterator.next();
        localrhp = new rhp();
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_pic_md5.has()) {
          localrhp.jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject1).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_pic_url.has()) {
          localrhp.d = ((articlesummary.PGCVideoInfo)localObject1).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_video_md5.has()) {
          localrhp.jdField_a_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject1).bytes_video_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_video_url.has()) {
          localrhp.jdField_b_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject1).bytes_video_url.get().toStringUtf8();
        }
        localrhn.jdField_b_of_type_JavaUtilArrayList.add(localrhp);
      }
    }
    if (paramPGCFeedsInfo.msg_gallery_feeds_info.has())
    {
      localrhn.jdField_a_of_type_Rhb = new rhb();
      paramPGCFeedsInfo = (articlesummary.GalleryPGCFeedsInfo)paramPGCFeedsInfo.msg_gallery_feeds_info.get();
      if (paramPGCFeedsInfo.uint64_pic_count.has()) {
        localrhn.jdField_a_of_type_Rhb.jdField_a_of_type_Long = paramPGCFeedsInfo.uint64_pic_count.get();
      }
    }
    return localrhn;
  }
  
  private static boolean b(List<rhp> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  public String toString()
  {
    return "PGCFeedsInfo{pGCPicInfos=" + a() + ", pGCVideoInfos=" + b() + ", pgcComments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", followCount=" + this.jdField_a_of_type_Int + ", followStatus=" + this.jdField_b_of_type_Int + ", isShortContent=" + this.jdField_a_of_type_Boolean + ", pgcFeedsType=" + this.jdField_c_of_type_Int + ", galleryPGCFeedsInfo=" + this.jdField_a_of_type_Rhb + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhn
 * JD-Core Version:    0.7.0.1
 */