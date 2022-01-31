import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import tencent.im.oidb.articlesummary.articlesummary.RecommendAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.RecommendFollowInfos;
import tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListRsp;
import tencent.im.oidb.oidb_0xc2f.RecommendAccountInfo;

public class qlt
{
  public int a;
  public String a;
  public HashMap<Long, RecommendFollowInfo> a;
  public List<RecommendFollowInfo> a;
  public boolean a;
  public byte[] a;
  public String b;
  public List<qkx> b;
  public boolean b;
  
  public qlt()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static qlt a(articlesummary.RecommendFollowInfos paramRecommendFollowInfos)
  {
    boolean bool = true;
    qlt localqlt = new qlt();
    if (paramRecommendFollowInfos.uint32_show_full_card.has()) {
      if (paramRecommendFollowInfos.uint32_show_full_card.get() != 1) {
        break label252;
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject1;
    for (;;)
    {
      localqlt.jdField_a_of_type_Boolean = bool;
      if (paramRecommendFollowInfos.bytes_account_next_cookie.has()) {
        localqlt.jdField_a_of_type_ArrayOfByte = paramRecommendFollowInfos.bytes_account_next_cookie.get().toByteArray();
      }
      localqlt.jdField_a_of_type_Int = paramRecommendFollowInfos.uint32_card_style.get();
      localqlt.jdField_a_of_type_JavaLangString = paramRecommendFollowInfos.bytes_card_title.get().toStringUtf8();
      localqlt.jdField_b_of_type_JavaLangString = paramRecommendFollowInfos.bytes_jump_url.get().toStringUtf8();
      if (!paramRecommendFollowInfos.rpt_recommend_account_info.has()) {
        return localqlt;
      }
      paramRecommendFollowInfos = paramRecommendFollowInfos.rpt_recommend_account_info.get();
      localObject2 = new HashMap();
      localObject3 = paramRecommendFollowInfos.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = RecommendFollowInfo.parseByPB((articlesummary.RecommendAccountInfo)((Iterator)localObject3).next());
        localqlt.jdField_a_of_type_JavaUtilList.add(localRecommendFollowInfo);
        if ((localqlt.jdField_a_of_type_Int == 2) && (!TextUtils.isEmpty(localRecommendFollowInfo.className)))
        {
          localObject1 = (List)((HashMap)localObject2).get(localRecommendFollowInfo.className);
          paramRecommendFollowInfos = (articlesummary.RecommendFollowInfos)localObject1;
          if (localObject1 == null)
          {
            paramRecommendFollowInfos = new ArrayList();
            ((HashMap)localObject2).put(localRecommendFollowInfo.className, paramRecommendFollowInfos);
          }
          if (paramRecommendFollowInfos.size() < 3) {
            paramRecommendFollowInfos.add(localRecommendFollowInfo);
          }
        }
      }
      label252:
      bool = false;
    }
    if (!((HashMap)localObject2).isEmpty())
    {
      paramRecommendFollowInfos = ((HashMap)localObject2).entrySet().iterator();
      while (paramRecommendFollowInfos.hasNext())
      {
        localObject1 = (Map.Entry)paramRecommendFollowInfos.next();
        localObject2 = (List)((Map.Entry)localObject1).getValue();
        if (((List)localObject2).size() == 3)
        {
          localObject3 = new qkx();
          ((qkx)localObject3).jdField_a_of_type_JavaLangString = ((String)((Map.Entry)localObject1).getKey());
          ((qkx)localObject3).jdField_a_of_type_JavaUtilList = ((List)localObject2);
          localqlt.jdField_b_of_type_JavaUtilList.add(localObject3);
        }
      }
    }
    return localqlt;
  }
  
  public static qlt a(oidb_0xc2f.GetFollowUserRecommendListRsp paramGetFollowUserRecommendListRsp)
  {
    qlt localqlt = new qlt();
    localqlt.jdField_b_of_type_JavaLangString = paramGetFollowUserRecommendListRsp.bytes_jump_url.get().toStringUtf8();
    if (paramGetFollowUserRecommendListRsp.rpt_msg_recommend_list.has())
    {
      paramGetFollowUserRecommendListRsp = paramGetFollowUserRecommendListRsp.rpt_msg_recommend_list.get().iterator();
      while (paramGetFollowUserRecommendListRsp.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = RecommendFollowInfo.parseByPB((oidb_0xc2f.RecommendAccountInfo)paramGetFollowUserRecommendListRsp.next());
        localqlt.jdField_a_of_type_JavaUtilList.add(localRecommendFollowInfo);
      }
    }
    return localqlt;
  }
  
  public byte[] a()
  {
    articlesummary.RecommendFollowInfos localRecommendFollowInfos = new articlesummary.RecommendFollowInfos();
    if (this.jdField_a_of_type_Boolean) {
      localRecommendFollowInfos.uint32_show_full_card.set(1);
    }
    ArrayList localArrayList;
    for (;;)
    {
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
        localRecommendFollowInfos.bytes_account_next_cookie.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
      }
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label132;
      }
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((RecommendFollowInfo)localIterator.next()).toPB());
      }
      localRecommendFollowInfos.uint32_show_full_card.set(0);
    }
    localRecommendFollowInfos.rpt_recommend_account_info.set(localArrayList);
    label132:
    localRecommendFollowInfos.uint32_card_style.set(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_JavaLangString != null) {
      localRecommendFollowInfos.bytes_card_title.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (this.jdField_b_of_type_JavaLangString != null) {
      localRecommendFollowInfos.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    return localRecommendFollowInfos.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qlt
 * JD-Core Version:    0.7.0.1
 */