import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class pdg
  implements View.OnClickListener, pcx
{
  private Context jdField_a_of_type_AndroidContentContext;
  private baxy jdField_a_of_type_Baxy;
  private bfst jdField_a_of_type_Bfst;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private pau jdField_a_of_type_Pau;
  private ram jdField_a_of_type_Ram;
  private rfk jdField_a_of_type_Rfk;
  private boolean jdField_a_of_type_Boolean;
  
  public pdg(Context paramContext, baxy parambaxy, ram paramram, ListView paramListView, bfst parambfst)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Baxy = parambaxy;
    this.jdField_a_of_type_Ram = paramram;
    this.jdField_a_of_type_Bfst = parambfst;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  private String a(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic title empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private URL a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo.mHeaderIconUrl == null) {
      try
      {
        String str = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_icon_url.get();
        if (TextUtils.isEmpty(str)) {
          QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic icon url empty");
        }
        if (TextUtils.isEmpty(str)) {
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject = null;
        }
        Object localObject = onh.a((String)localObject);
        paramArticleInfo.mHeaderIconUrl = ((URL)localObject);
        return localObject;
      }
    }
    return paramArticleInfo.mHeaderIconUrl;
  }
  
  private List<Long> a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend uin list empty");
      }
      return localArrayList;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  private void a(String paramString)
  {
    label92:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = onh.a();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", onh.e());
        paramString = "0X800744D";
        if (this.jdField_a_of_type_Pau != null)
        {
          if (shu.a(this.jdField_a_of_type_Pau.e()))
          {
            paramString = "0X8009357";
            break label92;
          }
        }
        else
        {
          nol.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
          return;
        }
        paramString = "0X800744D";
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  private void a(rfk paramrfk, pau parampau, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      pau localpau = (pau)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131379213);
      rfk localrfk = (rfk)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131379218);
      if ((localpau != null) && (localrfk != null) && (parampau.a().mGroupId == localpau.a().mGroupId))
      {
        localArrayList1.add(localrfk);
        localArrayList2.add(localpau);
      }
      i += 1;
    }
    paramrfk = new pdk(this, paramrfk, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    if (paramInt < localArrayList1.size())
    {
      parampau = (Animation)((rfk)localArrayList1.get(paramInt)).a().getTag(2131368790);
      if (paramInt != 0) {
        parampau.setAnimationListener(null);
      }
      for (;;)
      {
        ((rfk)localArrayList1.get(paramInt)).a().startAnimation(parampau);
        paramInt += 1;
        break;
        parampau.setAnimationListener(paramrfk);
      }
    }
  }
  
  private void a(boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    int k = 8;
    int i;
    label90:
    label123:
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = a(paramArticleInfo);
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        this.jdField_a_of_type_Rfk.c.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Rfk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (!paramBoolean) {
          break label205;
        }
        i = 8;
        ((KandianUrlImageView)localObject1).setVisibility(i);
        this.jdField_a_of_type_Rfk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
        localObject1 = this.jdField_a_of_type_Rfk.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView;
        int m = localObject1.length;
        i = 0;
        if (i >= m) {
          break label217;
        }
        localObject2 = localObject1[i];
        if (!paramBoolean) {
          break label210;
        }
      }
    }
    label205:
    label210:
    for (int j = 0;; j = 8)
    {
      localObject2.setVisibility(j);
      i += 1;
      break label123;
      this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 0);
      break;
      this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      break;
      i = 0;
      break label90;
    }
    label217:
    Object localObject1 = this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {
      if (a(paramArticleInfo).size() == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(i);
      this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramArticleInfo = this.jdField_a_of_type_Rfk.jdField_b_of_type_AndroidWidgetTextView;
      i = k;
      if (paramBoolean) {
        i = 0;
      }
      paramArticleInfo.setVisibility(i);
      this.jdField_a_of_type_Rfk.d.setVisibility(0);
      return;
      i = 8;
      continue;
      i = 0;
    }
  }
  
  private String b(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_jump_url.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic url empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  private String c(ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo = ((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
      if (TextUtils.isEmpty(paramArticleInfo)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend description empty");
      }
      return paramArticleInfo;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
        paramArticleInfo = null;
      }
    }
  }
  
  public void a(rfk paramrfk, pau parampau)
  {
    paramrfk = parampau.a();
    parampau = a(paramrfk);
    int i = 0;
    if (i < Math.min(4, parampau.size()))
    {
      if (onh.a()) {
        this.jdField_a_of_type_Rfk.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageDrawable(awwa.a(this.jdField_a_of_type_Baxy, String.valueOf(parampau.get(i)), 1));
      }
      for (;;)
      {
        String str = String.valueOf(parampau.get(i));
        this.jdField_a_of_type_Rfk.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setOnClickListener(new pdj(this, str, paramrfk));
        i += 1;
        break;
        this.jdField_a_of_type_Rfk.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(this.jdField_a_of_type_Ram.a(((Long)parampau.get(i)).longValue()));
      }
    }
    i = Math.min(4, parampau.size());
    while (i < 4)
    {
      this.jdField_a_of_type_Rfk.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setVisibility(8);
      i += 1;
    }
  }
  
  public void a(rfk paramrfk, pau parampau, int paramInt)
  {
    this.jdField_a_of_type_Rfk = paramrfk;
    this.jdField_a_of_type_Pau = parampau;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pau.a();
    if (this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_Rfk.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Pau.a()) {
        break label179;
      }
    }
    label179:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      if (this.jdField_a_of_type_Pau.a())
      {
        this.jdField_a_of_type_Rfk.a();
        if (this.jdField_a_of_type_Pau.c() != 3) {
          break;
        }
        this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Rfk.f.setVisibility(8);
        if (this.jdField_a_of_type_Rfk.g != null) {
          this.jdField_a_of_type_Rfk.g.setVisibility(8);
        }
        this.jdField_a_of_type_Rfk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(0);
        this.jdField_a_of_type_Rfk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setLogic(this.jdField_a_of_type_Ram, this.jdField_a_of_type_Baxy);
        this.jdField_a_of_type_Rfk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(parampau);
      }
      return;
    }
    this.jdField_a_of_type_Rfk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(8);
    this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidViewView.setVisibility(0);
    switch (this.jdField_a_of_type_Pau.c())
    {
    default: 
      this.jdField_a_of_type_Rfk.d.setOnClickListener(new pdh(this, parampau, paramrfk));
      return;
    case 1: 
      this.jdField_a_of_type_Boolean = false;
      a(false, localArticleInfo);
      localObject = a(localArticleInfo);
      if (localObject == null)
      {
        this.jdField_a_of_type_Rfk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_Rfk.c.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidWidgetTextView.setText(a(localArticleInfo));
        break;
        omr.a(this.jdField_a_of_type_Rfk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (URL)localObject, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(true, localArticleInfo);
    a(paramrfk, parampau);
    Object localObject = a(localArticleInfo);
    if (((List)localObject).size() == 1) {
      if (!onh.a()) {
        break label447;
      }
    }
    label447:
    for (localObject = bbcz.j((QQAppInterface)onh.a(), String.valueOf(((List)localObject).get(0)));; localObject = this.jdField_a_of_type_Ram.b(((Long)((List)localObject).get(0)).longValue()))
    {
      this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidWidgetTextView.setText(onh.d((String)localObject));
      this.jdField_a_of_type_Rfk.jdField_b_of_type_AndroidWidgetTextView.setText(c(localArticleInfo));
      break;
    }
  }
  
  public void a(rfk paramrfk, pau parampau, long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Pau.c() == 3) {
      this.jdField_a_of_type_Rfk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramLong, paramBitmap);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Rfk.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Pau.c() != 2) || (!onh.a()));
      paramrfk = a(parampau.a());
    } while ((paramrfk.size() <= 0) || (!paramrfk.contains(Long.valueOf(paramLong))));
    int i = paramrfk.indexOf(Long.valueOf(paramLong));
    this.jdField_a_of_type_Rfk.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(onh.c(this.jdField_a_of_type_Pau.a()));
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = a(this.jdField_a_of_type_Pau.a());
        if ((paramView != null) && (paramView.size() == 1))
        {
          paramView = omj.g + bbco.encodeToString(String.valueOf(paramView.get(0)).getBytes(), 2);
          onh.a(this.jdField_a_of_type_AndroidContentContext, paramView);
        }
      }
      else
      {
        paramView = b(this.jdField_a_of_type_Pau.a());
        if (!TextUtils.isEmpty(paramView))
        {
          onh.a(this.jdField_a_of_type_AndroidContentContext, paramView);
          continue;
          if (!this.jdField_a_of_type_Boolean)
          {
            paramView = b(this.jdField_a_of_type_Pau.a());
            if (!TextUtils.isEmpty(paramView)) {
              onh.a(this.jdField_a_of_type_AndroidContentContext, paramView);
            }
          }
          else
          {
            paramView = a(this.jdField_a_of_type_Pau.a());
            if (!paramView.isEmpty())
            {
              paramView = omj.g + bbco.encodeToString(String.valueOf(paramView.get(0)).getBytes(), 2);
              onh.a(this.jdField_a_of_type_AndroidContentContext, paramView);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdg
 * JD-Core Version:    0.7.0.1
 */