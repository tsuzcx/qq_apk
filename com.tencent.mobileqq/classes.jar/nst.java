import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class nst
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  View jdField_a_of_type_AndroidViewView;
  public TextView a;
  ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  public String a;
  public ArrayList<SocializeFeedsInfo.BiuCommentInfo> a;
  oqi jdField_a_of_type_Oqi = new nsu(this);
  pjg jdField_a_of_type_Pjg = new pjg();
  long jdField_b_of_type_Long;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private final String jdField_b_of_type_JavaLangString = "5";
  TextView c;
  
  public nst(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment, Context paramContext)
  {
    a(paramContext);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
  }
  
  private void a(long paramLong)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, new nsv(this, paramLong));
    String str = ReadInJoyUserInfoModule.a();
    if (localReadInJoyUserInfo != null) {
      str = localReadInJoyUserInfo.nick;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
  
  private void a(ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList)
  {
    paramArrayList = SocializeFeedsInfo.a(null, "5", this.jdField_a_of_type_Oqi, paramArrayList);
    this.c.setSpannableFactory(axkd.a);
    this.c.setText(paramArrayList);
  }
  
  private boolean a(ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramArrayList.next()).jdField_a_of_type_JavaLangString)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131494371, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301795));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305143));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298878));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297741));
  }
  
  public void a(MultiBiuSameContent paramMultiBiuSameContent, int paramInt)
  {
    a(paramMultiBiuSameContent.jdField_a_of_type_Long);
    this.c.setOnClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuReadInjoyFriendsBiuComponentFragment.a);
    Object localObject = oby.a(paramMultiBiuSameContent.jdField_b_of_type_Int, true);
    if (localObject != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(paramMultiBiuSameContent.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = paramMultiBiuSameContent.jdField_a_of_type_Long;
    this.jdField_a_of_type_Int = paramMultiBiuSameContent.c;
    this.jdField_b_of_type_Long = paramMultiBiuSameContent.jdField_b_of_type_Long;
    this.c.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuReadInjoyFriendsBiuComponentFragment.a);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuReadInjoyFriendsBiuComponentFragment.a);
    this.jdField_a_of_type_JavaLangString = ReadInjoyFriendsBiuComponentFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuReadInjoyFriendsBiuComponentFragment, paramMultiBiuSameContent.jdField_a_of_type_Long, paramMultiBiuSameContent.c, paramMultiBiuSameContent.jdField_b_of_type_Long);
    try
    {
      if ((paramMultiBiuSameContent.jdField_a_of_type_JavaUtilArrayList != null) && (!paramMultiBiuSameContent.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        this.jdField_a_of_type_JavaUtilArrayList = paramMultiBiuSameContent.jdField_a_of_type_JavaUtilArrayList;
        if (a(paramMultiBiuSameContent.jdField_a_of_type_JavaUtilArrayList))
        {
          this.c.setVisibility(8);
          return;
        }
        a(this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
    }
    catch (Exception paramMultiBiuSameContent)
    {
      QLog.e("ReadInjoyFriendsBiuComponentFragment", 2, "setData: ", paramMultiBiuSameContent);
      return;
    }
    if (TextUtils.isEmpty(paramMultiBiuSameContent.jdField_a_of_type_JavaLangString))
    {
      this.c.setVisibility(8);
      return;
    }
    localObject = new SpannableStringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMultiBiuSameContent.jdField_a_of_type_JavaLangString);
    ((SpannableStringBuilder)localObject).append(new axkd(localStringBuilder, 7, 16));
    this.c.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nst
 * JD-Core Version:    0.7.0.1
 */