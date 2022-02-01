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

public class rfe
{
  public int a;
  public String a;
  public ArrayList<rff> a;
  public res a;
  public boolean a;
  public int b;
  public ArrayList<rfg> b;
  public int c;
  
  public rfe()
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
    rff localrff;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localrff.toString() + "},") {
      localrff = (rff)localIterator.next();
    }
    return str + "]";
  }
  
  public static articlesummary.PGCFeedsInfo a(rfe paramrfe)
  {
    articlesummary.PGCFeedsInfo localPGCFeedsInfo = new articlesummary.PGCFeedsInfo();
    qlg.a(localPGCFeedsInfo.bytes_pgc_comments, paramrfe.jdField_a_of_type_JavaLangString);
    if (paramrfe.jdField_a_of_type_Boolean) {
      localPGCFeedsInfo.uint32_article_type.set(1);
    }
    qlg.a(localPGCFeedsInfo.uint32_myself_follow_status, paramrfe.jdField_b_of_type_Int);
    qlg.a(localPGCFeedsInfo.uint32_follow_counts, paramrfe.jdField_a_of_type_Int);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (a(paramrfe.jdField_a_of_type_JavaUtilArrayList))
    {
      localObject1 = new ArrayList();
      localObject2 = paramrfe.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (rff)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCPicInfo();
        qlg.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((rff)localObject3).jdField_a_of_type_JavaLangString);
        qlg.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((rff)localObject3).jdField_b_of_type_JavaLangString);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_height.set(((rff)localObject3).jdField_b_of_type_Int);
        ((articlesummary.PGCPicInfo)localObject4).uint32_pic_width.set(((rff)localObject3).jdField_a_of_type_Int);
        qlg.a(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((rff)localObject3).jdField_c_of_type_JavaLangString);
        qlg.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((rff)localObject3).d);
        qlg.a(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((rff)localObject3).jdField_a_of_type_Long);
        if (((rff)localObject3).jdField_a_of_type_Rfg != null)
        {
          articlesummary.PGCVideoInfo localPGCVideoInfo = new articlesummary.PGCVideoInfo();
          qlg.a(localPGCVideoInfo.bytes_vid, ((rff)localObject3).jdField_a_of_type_Rfg.e);
          qlg.a(localPGCVideoInfo.bytes_video_url, ((rff)localObject3).jdField_a_of_type_Rfg.jdField_b_of_type_JavaLangString);
          qlg.a(localPGCVideoInfo.bytes_video_md5, ((rff)localObject3).jdField_a_of_type_Rfg.jdField_a_of_type_JavaLangString);
          qlg.a(localPGCVideoInfo.bytes_pic_md5, ((rff)localObject3).jdField_a_of_type_Rfg.jdField_c_of_type_JavaLangString);
          qlg.a(localPGCVideoInfo.bytes_pic_url, ((rff)localObject3).jdField_a_of_type_Rfg.d);
          localPGCVideoInfo.uint32_duration.set(((rff)localObject3).jdField_a_of_type_Rfg.jdField_a_of_type_Int);
          localPGCVideoInfo.uint32_busi_type.set(((rff)localObject3).jdField_a_of_type_Rfg.jdField_b_of_type_Int);
          ((articlesummary.PGCPicInfo)localObject4).msg_video_info.set(localPGCVideoInfo);
        }
        ((articlesummary.PGCPicInfo)localObject4).is_animation.set(((rff)localObject3).jdField_c_of_type_Int);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_pic_info_list.set((List)localObject1);
    }
    if (b(paramrfe.jdField_b_of_type_JavaUtilArrayList))
    {
      localObject1 = new ArrayList();
      localObject2 = paramrfe.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (rfg)((Iterator)localObject2).next();
        localObject4 = new articlesummary.PGCVideoInfo();
        qlg.a(((articlesummary.PGCVideoInfo)localObject4).bytes_video_url, ((rfg)localObject3).jdField_b_of_type_JavaLangString);
        qlg.a(((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5, ((rfg)localObject3).jdField_a_of_type_JavaLangString);
        qlg.a(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5, ((rfg)localObject3).jdField_c_of_type_JavaLangString);
        qlg.a(((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url, ((rfg)localObject3).d);
        ((List)localObject1).add(localObject4);
      }
      localPGCFeedsInfo.msg_pgc_video_info_list.set((List)localObject1);
    }
    localPGCFeedsInfo.enum_pgc_feeds_type.set(paramrfe.jdField_c_of_type_Int);
    if (paramrfe.jdField_a_of_type_Res != null)
    {
      localObject1 = new articlesummary.GalleryPGCFeedsInfo();
      qlg.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_pic_count, paramrfe.jdField_a_of_type_Res.jdField_a_of_type_Long);
      qlg.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_source, paramrfe.jdField_a_of_type_Res.b);
      qlg.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).uint64_sub_source, paramrfe.jdField_a_of_type_Res.c);
      qlg.a(((articlesummary.GalleryPGCFeedsInfo)localObject1).bytes_gallery_url, paramrfe.jdField_a_of_type_Res.jdField_a_of_type_JavaLangString);
      if (a(paramrfe.jdField_a_of_type_Res.jdField_a_of_type_JavaUtilArrayList))
      {
        localObject2 = new ArrayList();
        paramrfe = paramrfe.jdField_a_of_type_Res.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramrfe.hasNext())
        {
          localObject3 = (rff)paramrfe.next();
          localObject4 = new articlesummary.PGCPicInfo();
          qlg.a(((articlesummary.PGCPicInfo)localObject4).uint32_pic_width, ((rff)localObject3).jdField_a_of_type_Int);
          qlg.a(((articlesummary.PGCPicInfo)localObject4).uint32_pic_height, ((rff)localObject3).jdField_b_of_type_Int);
          qlg.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_md5, ((rff)localObject3).jdField_a_of_type_JavaLangString);
          qlg.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_url, ((rff)localObject3).jdField_b_of_type_JavaLangString);
          qlg.a(((articlesummary.PGCPicInfo)localObject4).bytes_thumbnail_url, ((rff)localObject3).jdField_c_of_type_JavaLangString);
          qlg.a(((articlesummary.PGCPicInfo)localObject4).is_animation, ((rff)localObject3).jdField_c_of_type_Int);
          qlg.a(((articlesummary.PGCPicInfo)localObject4).bytes_pic_desc, ((rff)localObject3).d);
          qlg.a(((articlesummary.PGCPicInfo)localObject4).uint64_gallery_index, ((rff)localObject3).jdField_a_of_type_Long);
          ((List)localObject2).add(localObject4);
        }
      }
      localPGCFeedsInfo.msg_gallery_feeds_info.set((MessageMicro)localObject1);
    }
    return localPGCFeedsInfo;
  }
  
  private static boolean a(List<rff> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  private String b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    rfg localrfg;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localrfg.toString() + "},") {
      localrfg = (rfg)localIterator.next();
    }
    return str + "]";
  }
  
  private static rfe b(articlesummary.PGCFeedsInfo paramPGCFeedsInfo)
  {
    rfe localrfe = new rfe();
    if (paramPGCFeedsInfo.bytes_pgc_comments.has()) {
      localrfe.jdField_a_of_type_JavaLangString = paramPGCFeedsInfo.bytes_pgc_comments.get().toStringUtf8();
    }
    if (paramPGCFeedsInfo.uint32_myself_follow_status.has()) {
      localrfe.jdField_b_of_type_Int = paramPGCFeedsInfo.uint32_myself_follow_status.get();
    }
    if (paramPGCFeedsInfo.uint32_follow_counts.has()) {
      localrfe.jdField_a_of_type_Int = paramPGCFeedsInfo.uint32_follow_counts.get();
    }
    if (paramPGCFeedsInfo.uint32_article_type.has()) {
      localrfe.jdField_a_of_type_Boolean = true;
    }
    Iterator localIterator;
    Object localObject1;
    rfg localrfg;
    if (paramPGCFeedsInfo.msg_pgc_pic_info_list.has())
    {
      localIterator = paramPGCFeedsInfo.msg_pgc_pic_info_list.get().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (articlesummary.PGCPicInfo)localIterator.next();
        localObject1 = new rff();
        if (((articlesummary.PGCPicInfo)localObject2).bytes_pic_md5.has()) {
          ((rff)localObject1).jdField_a_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).bytes_pic_url.has()) {
          ((rff)localObject1).jdField_b_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).uint32_pic_height.has()) {
          ((rff)localObject1).jdField_b_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).uint32_pic_height.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).uint32_pic_width.has()) {
          ((rff)localObject1).jdField_a_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).uint32_pic_width.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).is_animation.has()) {
          ((rff)localObject1).jdField_c_of_type_Int = ((articlesummary.PGCPicInfo)localObject2).is_animation.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).bytes_thumbnail_url.has()) {
          ((rff)localObject1).jdField_c_of_type_JavaLangString = ((articlesummary.PGCPicInfo)localObject2).bytes_thumbnail_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).bytes_pic_desc.has()) {
          ((rff)localObject1).d = ((articlesummary.PGCPicInfo)localObject2).bytes_pic_desc.get().toStringUtf8();
        }
        if (((articlesummary.PGCPicInfo)localObject2).uint64_gallery_index.has()) {
          ((rff)localObject1).jdField_a_of_type_Long = ((articlesummary.PGCPicInfo)localObject2).uint64_gallery_index.get();
        }
        if (((articlesummary.PGCPicInfo)localObject2).msg_video_info.has())
        {
          localrfg = new rfg();
          localObject2 = (articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject2).msg_video_info.get();
          if (((articlesummary.PGCVideoInfo)localObject2).bytes_pic_md5.has()) {
            localrfg.jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject2).bytes_pic_md5.get().toStringUtf8();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).bytes_pic_url.has()) {
            localrfg.d = ((articlesummary.PGCVideoInfo)localObject2).bytes_pic_url.get().toStringUtf8();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).bytes_vid.has()) {
            localrfg.e = ((articlesummary.PGCVideoInfo)localObject2).bytes_vid.get().toStringUtf8();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).uint32_duration.has()) {
            localrfg.jdField_a_of_type_Int = ((articlesummary.PGCVideoInfo)localObject2).uint32_duration.get();
          }
          if (((articlesummary.PGCVideoInfo)localObject2).uint32_busi_type.has()) {
            localrfg.jdField_b_of_type_Int = ((articlesummary.PGCVideoInfo)localObject2).uint32_busi_type.get();
          }
          ((rff)localObject1).jdField_a_of_type_Rfg = localrfg;
        }
        localrfe.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
    if (paramPGCFeedsInfo.msg_pgc_video_info_list.has())
    {
      localIterator = paramPGCFeedsInfo.msg_pgc_video_info_list.get().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (articlesummary.PGCVideoInfo)localIterator.next();
        localrfg = new rfg();
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_pic_md5.has()) {
          localrfg.jdField_c_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject1).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_pic_url.has()) {
          localrfg.d = ((articlesummary.PGCVideoInfo)localObject1).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_video_md5.has()) {
          localrfg.jdField_a_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject1).bytes_video_md5.get().toStringUtf8();
        }
        if (((articlesummary.PGCVideoInfo)localObject1).bytes_video_url.has()) {
          localrfg.jdField_b_of_type_JavaLangString = ((articlesummary.PGCVideoInfo)localObject1).bytes_video_url.get().toStringUtf8();
        }
        localrfe.jdField_b_of_type_JavaUtilArrayList.add(localrfg);
      }
    }
    if (paramPGCFeedsInfo.msg_gallery_feeds_info.has())
    {
      localrfe.jdField_a_of_type_Res = new res();
      paramPGCFeedsInfo = (articlesummary.GalleryPGCFeedsInfo)paramPGCFeedsInfo.msg_gallery_feeds_info.get();
      if (paramPGCFeedsInfo.uint64_pic_count.has()) {
        localrfe.jdField_a_of_type_Res.jdField_a_of_type_Long = paramPGCFeedsInfo.uint64_pic_count.get();
      }
    }
    return localrfe;
  }
  
  private static boolean b(List<rfg> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  public String toString()
  {
    return "PGCFeedsInfo{pGCPicInfos=" + a() + ", pGCVideoInfos=" + b() + ", pgcComments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", followCount=" + this.jdField_a_of_type_Int + ", followStatus=" + this.jdField_b_of_type_Int + ", isShortContent=" + this.jdField_a_of_type_Boolean + ", pgcFeedsType=" + this.jdField_c_of_type_Int + ", galleryPGCFeedsInfo=" + this.jdField_a_of_type_Res + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfe
 * JD-Core Version:    0.7.0.1
 */