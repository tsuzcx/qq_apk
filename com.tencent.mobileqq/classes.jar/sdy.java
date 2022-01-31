import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.CommunityConfigInfo;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.widget.DisableSlideHorizontalListView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xc90.CommunityConfigInfo;
import tencent.im.oidb.oidb_0xc90.RspBody;

public class sdy
  extends sec
{
  public sdy(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController)
  {
    super(paramReadInJoyDiandianHeaderController);
  }
  
  public void a(boolean paramBoolean, int paramInt, oidb_0xc90.RspBody paramRspBody)
  {
    Object localObject = paramRspBody.rpt_community_info_item.get();
    this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      oidb_0xc90.CommunityConfigInfo localCommunityConfigInfo = (oidb_0xc90.CommunityConfigInfo)((Iterator)localObject).next();
      CommunityConfigInfo localCommunityConfigInfo1 = new CommunityConfigInfo();
      localCommunityConfigInfo1.name = localCommunityConfigInfo.bytes_name.get().toStringUtf8();
      localCommunityConfigInfo1.jumpUrl = localCommunityConfigInfo.bytes_jump_home_page_url.get().toStringUtf8();
      localCommunityConfigInfo1.bid = localCommunityConfigInfo.uint64_community_bid.get();
      localCommunityConfigInfo1.picUrl = localCommunityConfigInfo.bytes_pic_url.get().toStringUtf8();
      localCommunityConfigInfo1.dynamicCount = localCommunityConfigInfo.uint32_dynamic_count.get();
      localCommunityConfigInfo1.followStatus = localCommunityConfigInfo.uint32_follow_status.get();
      this.a.jdField_a_of_type_JavaUtilList.add(localCommunityConfigInfo1);
    }
    this.a.jdField_a_of_type_JavaLangString = paramRspBody.bytes_jump_concern_community_url.get().toStringUtf8();
    this.a.c = paramRspBody.bytes_more_url_wording.get().toStringUtf8();
    this.a.jdField_b_of_type_JavaLangString = paramRspBody.bytes_community_title_wording.get().toStringUtf8();
    this.a.d = paramRspBody.bytes_jump_community_channel_url.get().toStringUtf8();
    if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_b_of_type_JavaLangString);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (TextUtils.isEmpty(this.a.c)) {
        break label456;
      }
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.c);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new sdz(this));
      }
      if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() <= 0) || (ReadInJoyDiandianHeaderController.a(this.a).a())) {
        break label471;
      }
      this.a.jdField_a_of_type_Seb = new seb(this.a, this.a.jdField_a_of_type_JavaUtilList);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetDisableSlideHorizontalListView.setAdapter(this.a.jdField_a_of_type_Seb);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label456:
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label471:
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sdy
 * JD-Core Version:    0.7.0.1
 */