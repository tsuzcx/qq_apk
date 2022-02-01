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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class qle
  implements View.OnClickListener, qkv
{
  private Context jdField_a_of_type_AndroidContentContext;
  private blcn jdField_a_of_type_Blcn;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private qfw jdField_a_of_type_Qfw;
  private szd jdField_a_of_type_Szd;
  private tbs jdField_a_of_type_Tbs;
  private boolean jdField_a_of_type_Boolean;
  
  public qle(Context paramContext, FaceDecoder paramFaceDecoder, szd paramszd, ListView paramListView, blcn paramblcn)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Szd = paramszd;
    this.jdField_a_of_type_Blcn = paramblcn;
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
        Object localObject = pqa.a((String)localObject);
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
        JSONObject localJSONObject = pqf.a();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", pqu.a());
        paramString = "0X800744D";
        if (this.jdField_a_of_type_Qfw != null)
        {
          if (uvs.a(this.jdField_a_of_type_Qfw.e()))
          {
            paramString = "0X8009357";
            break label92;
          }
        }
        else
        {
          olh.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
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
  
  private void a(tbs paramtbs, qfw paramqfw, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      qfw localqfw = (qfw)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131381183);
      tbs localtbs = (tbs)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131381188);
      if ((localqfw != null) && (localtbs != null) && (paramqfw.a().mGroupId == localqfw.a().mGroupId))
      {
        localArrayList1.add(localtbs);
        localArrayList2.add(localqfw);
      }
      i += 1;
    }
    paramtbs = new qli(this, paramtbs, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    if (paramInt < localArrayList1.size())
    {
      paramqfw = (Animation)((tbs)localArrayList1.get(paramInt)).a().getTag(2131369656);
      if (paramInt != 0) {
        paramqfw.setAnimationListener(null);
      }
      for (;;)
      {
        ((tbs)localArrayList1.get(paramInt)).a().startAnimation(paramqfw);
        paramInt += 1;
        break;
        paramqfw.setAnimationListener(paramtbs);
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
        this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        this.jdField_a_of_type_Tbs.c.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Tbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (!paramBoolean) {
          break label205;
        }
        i = 8;
        ((KandianUrlImageView)localObject1).setVisibility(i);
        this.jdField_a_of_type_Tbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
        localObject1 = this.jdField_a_of_type_Tbs.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView;
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
      this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 0);
      break;
      this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      break;
      i = 0;
      break label90;
    }
    label217:
    Object localObject1 = this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {
      if (a(paramArticleInfo).size() == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(i);
      this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramArticleInfo = this.jdField_a_of_type_Tbs.jdField_b_of_type_AndroidWidgetTextView;
      i = k;
      if (paramBoolean) {
        i = 0;
      }
      paramArticleInfo.setVisibility(i);
      this.jdField_a_of_type_Tbs.d.setVisibility(0);
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
  
  public void a(tbs paramtbs, qfw paramqfw)
  {
    paramtbs = paramqfw.a();
    paramqfw = a(paramtbs);
    int i = 0;
    if (i < Math.min(4, paramqfw.size()))
    {
      if (pnn.a()) {
        this.jdField_a_of_type_Tbs.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageDrawable(bcnc.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, String.valueOf(paramqfw.get(i)), 1));
      }
      for (;;)
      {
        String str = String.valueOf(paramqfw.get(i));
        this.jdField_a_of_type_Tbs.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setOnClickListener(new qlh(this, str, paramtbs));
        i += 1;
        break;
        this.jdField_a_of_type_Tbs.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(this.jdField_a_of_type_Szd.a(((Long)paramqfw.get(i)).longValue()));
      }
    }
    i = Math.min(4, paramqfw.size());
    while (i < 4)
    {
      this.jdField_a_of_type_Tbs.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setVisibility(8);
      i += 1;
    }
  }
  
  public void a(tbs paramtbs, qfw paramqfw, int paramInt)
  {
    this.jdField_a_of_type_Tbs = paramtbs;
    this.jdField_a_of_type_Qfw = paramqfw;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qfw.a();
    if (this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_Tbs.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Qfw.a()) {
        break label179;
      }
    }
    label179:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      if (this.jdField_a_of_type_Qfw.a())
      {
        this.jdField_a_of_type_Tbs.a();
        if (this.jdField_a_of_type_Qfw.c() != 3) {
          break;
        }
        this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Tbs.f.setVisibility(8);
        if (this.jdField_a_of_type_Tbs.g != null) {
          this.jdField_a_of_type_Tbs.g.setVisibility(8);
        }
        this.jdField_a_of_type_Tbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(0);
        this.jdField_a_of_type_Tbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setLogic(this.jdField_a_of_type_Szd, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
        this.jdField_a_of_type_Tbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramqfw);
      }
      return;
    }
    this.jdField_a_of_type_Tbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(8);
    this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidViewView.setVisibility(0);
    switch (this.jdField_a_of_type_Qfw.c())
    {
    default: 
      this.jdField_a_of_type_Tbs.d.setOnClickListener(new qlf(this, paramqfw, paramtbs));
      return;
    case 1: 
      this.jdField_a_of_type_Boolean = false;
      a(false, localArticleInfo);
      localObject = a(localArticleInfo);
      if (localObject == null)
      {
        this.jdField_a_of_type_Tbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_Tbs.c.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidWidgetTextView.setText(a(localArticleInfo));
        break;
        pjr.a(this.jdField_a_of_type_Tbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (URL)localObject, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(true, localArticleInfo);
    a(paramtbs, paramqfw);
    Object localObject = a(localArticleInfo);
    if (((List)localObject).size() == 1) {
      if (!pnn.a()) {
        break label447;
      }
    }
    label447:
    for (localObject = ContactUtils.getFriendDisplayName((QQAppInterface)pkh.a(), String.valueOf(((List)localObject).get(0)));; localObject = this.jdField_a_of_type_Szd.a(((Long)((List)localObject).get(0)).longValue()))
    {
      this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidWidgetTextView.setText(prg.a((String)localObject));
      this.jdField_a_of_type_Tbs.jdField_b_of_type_AndroidWidgetTextView.setText(c(localArticleInfo));
      break;
    }
  }
  
  public void a(tbs paramtbs, qfw paramqfw, long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Qfw.c() == 3) {
      this.jdField_a_of_type_Tbs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramLong, paramBitmap);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Tbs.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Qfw.c() != 2) || (!pnn.a()));
      paramtbs = a(paramqfw.a());
    } while ((paramtbs.size() <= 0) || (!paramtbs.contains(Long.valueOf(paramLong))));
    int i = paramtbs.indexOf(Long.valueOf(paramLong));
    this.jdField_a_of_type_Tbs.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(pqw.b(this.jdField_a_of_type_Qfw.a()));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = a(this.jdField_a_of_type_Qfw.a());
        if ((localObject != null) && (((List)localObject).size() == 1))
        {
          localObject = pjj.g + bhcu.encodeToString(String.valueOf(((List)localObject).get(0)).getBytes(), 2);
          pkh.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
        }
      }
      else
      {
        localObject = b(this.jdField_a_of_type_Qfw.a());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          pkh.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
          continue;
          if (!this.jdField_a_of_type_Boolean)
          {
            localObject = b(this.jdField_a_of_type_Qfw.a());
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              pkh.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
            }
          }
          else
          {
            localObject = a(this.jdField_a_of_type_Qfw.a());
            if (!((List)localObject).isEmpty())
            {
              localObject = pjj.g + bhcu.encodeToString(String.valueOf(((List)localObject).get(0)).getBytes(), 2);
              pkh.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qle
 * JD-Core Version:    0.7.0.1
 */