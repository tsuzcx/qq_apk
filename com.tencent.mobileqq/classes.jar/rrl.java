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

public class rrl
{
  public int a;
  public String a;
  public ArrayList<rrm> a;
  public rqz a;
  public boolean a;
  public int b;
  public ArrayList<rrn> b;
  public int c;
  
  public rrl()
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
    rrm localrrm;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localrrm.toString() + "},") {
      localrrm = (rrm)localIterator.next();
    }
    return str + "]";
  }
  
  public static articlesummary.PGCFeedsInfo a(rrl paramrrl)
  {
    articlesummary.PGCFeedsInfo localPGCFeedsInfo = new articlesummary.PGCFeedsInfo();
    qxl.a(localPGCFeedsInfo.bytes_pgc_comments, paramrrl.jdField_a_of_type_JavaLangString);
    if (paramrrl.jdField_a_of_type_Boolean) {
      localPGCFeedsInfo.uint32_article_type.set(1);
    }
    qxl.a(localPGCFeedsInfo.uint32_myself_follow_status, paramrrl.jdField_b_of_type_Int);
    qxl.a(localPGCFeedsInfo.uint32_follow_counts, paramrrl.jdField_a_of_type_Int);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (a(paramrrl.jdField_a_of_type_JavaUtilArrayList))
    {
      localObject1 = new ArrayList();
      localObject2 = paramrrl.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (rrm)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCPicInfo();
        qxl.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((rrm)localObject3).jdField_a_of_type_JavaLangString);
        qxl.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((rrm)localObject3).jdField_b_of_type_JavaLangString);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_height.set(((rrm)localObject3).jdField_b_of_type_Int);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_width.set(((rrm)localObject3).jdField_a_of_type_Int);
        qxl.a(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((rrm)localObject3).jdField_c_of_type_JavaLangString);
        qxl.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((rrm)localObject3).d);
        qxl.a(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((rrm)localObject3).jdField_a_of_type_Long);
        if (((rrm)localObject3).jdField_a_of_type_Rrn != null)
        {
          articlesummary.PGCVideoInfo localPGCVideoInfo = new articlesummary.PGCVideoInfo();
          qxl.a(localPGCVideoInfo.bytes_vid, ((rrm)localObject3).jdField_a_of_type_Rrn.e);
          qxl.a(localPGCVideoInfo.bytes_video_url, ((rrm)localObject3).jdField_a_of_type_Rrn.jdField_b_of_type_JavaLangString);
          qxl.a(localPGCVideoInfo.bytes_video_md5, ((rrm)localObject3).jdField_a_of_type_Rrn.jdField_a_of_type_JavaLangString);
          qxl.a(localPGCVideoInfo.bytes_pic_md5, ((rrm)localObject3).jdField_a_of_type_Rrn.jdField_c_of_type_JavaLangString);
          qxl.a(localPGCVideoInfo.bytes_pic_url, ((rrm)localObject3).jdField_a_of_type_Rrn.d);
          localPGCVideoInfo.uint32_duration.set(((rrm)localObject3).jdField_a_of_type_Rrn.jdField_a_of_type_Int);
          localPGCVideoInfo.uint32_busi_type.set(((rrm)localObject3).jdField_a_of_type_Rrn.jdField_b_of_type_Int);
          ((articlesummary.PGCPicInfo)localObject4).msg_video_info.set(localPGCVideoInfo);
        }
        ((articlesummary.PGCPicInfo)localObject4).is_animation.set(((rrm)localObject3).jdField_c_of_type_Int);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_pic_info_list.set((List)localObject1);
    }
    if (b(paramrrl.jdField_b_of_type_JavaUtilArrayList))
    {
      localObject1 = new ArrayList();
      localObject2 = paramrrl.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (rrn)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCVideoInfo();
        qxl.a(((articlesummary.PGCVideoInfo)localObject4).bytes_video_url, ((rrn)localObject3).jdField_b_of_type_JavaLangString);
        qxl.a(((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5, ((rrn)localObject3).jdField_a_of_type_JavaLangString);
        qxl.a(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5, ((rrn)localObject3).jdField_c_of_type_JavaLangString);
        qxl.a(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url, ((rrn)localObject3).d);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_video_info_list.set((List)localObject1);
    }
    localPGCFeedsInfo.enum_pgc_feeds_type.set(paramrrl.jdField_c_of_type_Int);
    if (paramrrl.jdField_a_of_type_Rqz != null)
    {
      localObject1 = new articlesummary.GalleryPGCFeedsInfo();
      qxl.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_pic_count, paramrrl.jdField_a_of_type_Rqz.jdField_a_of_type_Long);
      qxl.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_source, paramrrl.jdField_a_of_type_Rqz.b);
      qxl.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_sub_source, paramrrl.jdField_a_of_type_Rqz.c);
      qxl.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).bytes_gallery_url, paramrrl.jdField_a_of_type_Rqz.jdField_a_of_type_JavaLangString);
      if (a(paramrrl.jdField_a_of_type_Rqz.jdField_a_of_type_JavaUtilArrayList))
      {
        localObject2 = new ArrayList();
        paramrrl = paramrrl.jdField_a_of_type_Rqz.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramrrl.hasNext())
        {
          localObject3 = (rrm)paramrrl.next();
          localObject4 = new articlesummary.PGCPicInfo();
          qxl.a(((articlesummary.PGCPicInfo)localObject4).uint32_pic_width, ((rrm)localObject3).jdField_a_of_type_Int);
          qxl.a(((articlesummary.PGCPicInfo)localObject4).uint32_pic_height, ((rrm)localObject3).jdField_b_of_type_Int);
          qxl.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((rrm)localObject3).jdField_a_of_type_JavaLangString);
          qxl.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((rrm)localObject3).jdField_b_of_type_JavaLangString);
          qxl.a(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((rrm)localObject3).jdField_c_of_type_JavaLangString);
          qxl.a(((articlesummary.PGCPicInfo)localObject4).is_animation, ((rrm)localObject3).jdField_c_of_type_Int);
          qxl.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((rrm)localObject3).d);
          qxl.a(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((rrm)localObject3).jdField_a_of_type_Long);
          ((List)localObject2).add(localObject4);
        }
      }
      localPGCFeedsInfo.msg_gallery_feeds_info.set((MessageMicro)localObject1);
    }
    return localPGCFeedsInfo;
  }
  
  private static void a(articlesummary.PGCFeedsInfo paramPGCFeedsInfo, rrl paramrrl)
  {
    paramPGCFeedsInfo = paramPGCFeedsInfo.msg_pgc_video_info_list.get().iterator();
    while (paramPGCFeedsInfo.hasNext())
    {
      articlesummary.PGCVideoInfo localPGCVideoInfo = (articlesummary.PGCVideoInfo)paramPGCFeedsInfo.next();
      rrn localrrn = new rrn();
      if (localPGCVideoInfo.bytes_pic_md5.has()) {
        localrrn.jdField_c_of_type_JavaLangString = localPGCVideoInfo.bytes_pic_md5.get().toStringUtf8();
      }
      if (localPGCVideoInfo.bytes_pic_url.has()) {
        localrrn.d = localPGCVideoInfo.bytes_pic_url.get().toStringUtf8();
      }
      if (localPGCVideoInfo.bytes_video_md5.has()) {
        localrrn.jdField_a_of_type_JavaLangString = localPGCVideoInfo.bytes_video_md5.get().toStringUtf8();
      }
      if (localPGCVideoInfo.bytes_video_url.has()) {
        localrrn.jdField_b_of_type_JavaLangString = localPGCVideoInfo.bytes_video_url.get().toStringUtf8();
      }
      paramrrl.jdField_b_of_type_JavaUtilArrayList.add(localrrn);
    }
  }
  
  private static boolean a(List<rrm> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  private String b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    rrn localrrn;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localrrn.toString() + "},") {
      localrrn = (rrn)localIterator.next();
    }
    return str + "]";
  }
  
  private static rrl b(articlesummary.PGCFeedsInfo paramPGCFeedsInfo)
  {
    rrl localrrl = new rrl();
    if (paramPGCFeedsInfo.bytes_pgc_comments.has()) {
      localrrl.jdField_a_of_type_JavaLangString = paramPGCFeedsInfo.bytes_pgc_comments.get().toStringUtf8();
    }
    if (paramPGCFeedsInfo.uint32_myself_follow_status.has()) {
      localrrl.jdField_b_of_type_Int = paramPGCFeedsInfo.uint32_myself_follow_status.get();
    }
    if (paramPGCFeedsInfo.uint32_follow_counts.has()) {
      localrrl.jdField_a_of_type_Int = paramPGCFeedsInfo.uint32_follow_counts.get();
    }
    if (paramPGCFeedsInfo.uint32_article_type.has()) {
      localrrl.jdField_a_of_type_Boolean = true;
    }
    if (paramPGCFeedsInfo.msg_pgc_pic_info_list.has()) {
      b(paramPGCFeedsInfo, localrrl);
    }
    if (paramPGCFeedsInfo.msg_pgc_video_info_list.has()) {
      a(paramPGCFeedsInfo, localrrl);
    }
    if (paramPGCFeedsInfo.msg_gallery_feeds_info.has())
    {
      localrrl.jdField_a_of_type_Rqz = new rqz();
      paramPGCFeedsInfo = (articlesummary.GalleryPGCFeedsInfo)paramPGCFeedsInfo.msg_gallery_feeds_info.get();
      if (paramPGCFeedsInfo.uint64_pic_count.has()) {
        localrrl.jdField_a_of_type_Rqz.jdField_a_of_type_Long = paramPGCFeedsInfo.uint64_pic_count.get();
      }
    }
    return localrrl;
  }
  
  private static void b(articlesummary.PGCFeedsInfo paramPGCFeedsInfo, rrl paramrrl)
  {
    paramPGCFeedsInfo = paramPGCFeedsInfo.msg_pgc_pic_info_list.get().iterator();
    while (paramPGCFeedsInfo.hasNext())
    {
      Object localObject = (articlesummary.PGCPicInfo)paramPGCFeedsInfo.next();
      rrm localrrm = new rrm();
      if (((articlesummary.PGCPicInfo)localObject).bytes_pic_md5.has()) {
        localrrm.jdField_a_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject).bytes_pic_md5.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).bytes_pic_url.has()) {
        localrrm.jdField_b_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject).bytes_pic_url.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).uint32_pic_height.has()) {
        localrrm.jdField_b_of_type_Int = ((articlesummary.PGCPicInfo)localObject).uint32_pic_height.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).uint32_pic_width.has()) {
        localrrm.jdField_a_of_type_Int = ((articlesummary.PGCPicInfo)localObject).uint32_pic_width.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).is_animation.has()) {
        localrrm.jdField_c_of_type_Int = ((articlesummary.PGCPicInfo)localObject).is_animation.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).bytes_thumbnail_url.has()) {
        localrrm.jdField_c_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject).bytes_thumbnail_url.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).bytes_pic_desc.has()) {
        localrrm.d = ((articlesummary.PGCPicInfo)localObject).bytes_pic_desc.get().toStringUtf8();
      }
      if (((articlesummary.PGCPicInfo)localObject).uint64_gallery_index.has()) {
        localrrm.jdField_a_of_type_Long = ((articlesummary.PGCPicInfo)localObject).uint64_gallery_index.get();
      }
      if (((articlesummary.PGCPicInfo)localObject).msg_video_info.has())
      {
        rrn localrrn = new rrn();
        localObject = (articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject).msg_video_info.get();
        if (((articlesummary.PGCVideoInfo)localObject).bytes_pic_md5.has()) {
          localrrn.jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject).bytes_pic_url.has()) {
          localrrn.d = ((articlesummary.PGCVideoInfo)localObject).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject).bytes_vid.has()) {
          localrrn.e = ((articlesummary.PGCVideoInfo)localObject).bytes_vid.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject).uint32_duration.has()) {
          localrrn.jdField_a_of_type_Int = ((articlesummary.PGCVideoInfo)localObject).uint32_duration.get();
        }
        if (((articlesummary.PGCVideoInfo)localObject).uint32_busi_type.has()) {
          localrrn.jdField_b_of_type_Int = ((articlesummary.PGCVideoInfo)localObject).uint32_busi_type.get();
        }
        localrrm.jdField_a_of_type_Rrn = localrrn;
      }
      paramrrl.jdField_a_of_type_JavaUtilArrayList.add(localrrm);
    }
  }
  
  private static boolean b(List<rrn> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  public String toString()
  {
    return "PGCFeedsInfo{pGCPicInfos=" + a() + ", pGCVideoInfos=" + b() + ", pgcComments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", followCount=" + this.jdField_a_of_type_Int + ", followStatus=" + this.jdField_b_of_type_Int + ", isShortContent=" + this.jdField_a_of_type_Boolean + ", pgcFeedsType=" + this.jdField_c_of_type_Int + ", galleryPGCFeedsInfo=" + this.jdField_a_of_type_Rqz + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrl
 * JD-Core Version:    0.7.0.1
 */