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

public class pyz
  implements View.OnClickListener, pyq
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bjrb jdField_a_of_type_Bjrb;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private pvc jdField_a_of_type_Pvc;
  private slt jdField_a_of_type_Slt;
  private soh jdField_a_of_type_Soh;
  private boolean jdField_a_of_type_Boolean;
  
  public pyz(Context paramContext, FaceDecoder paramFaceDecoder, slt paramslt, ListView paramListView, bjrb parambjrb)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Slt = paramslt;
    this.jdField_a_of_type_Bjrb = parambjrb;
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
        Object localObject = pay.a((String)localObject);
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
        JSONObject localJSONObject = pay.a();
        localJSONObject.put("feeds_source", paramString);
        localJSONObject.put("kandian_mode", pay.e());
        paramString = "0X800744D";
        if (this.jdField_a_of_type_Pvc != null)
        {
          if (uhv.a(this.jdField_a_of_type_Pvc.e()))
          {
            paramString = "0X8009357";
            break label92;
          }
        }
        else
        {
          odq.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
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
  
  private void a(soh paramsoh, pvc parampvc, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      pvc localpvc = (pvc)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131380831);
      soh localsoh = (soh)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131380836);
      if ((localpvc != null) && (localsoh != null) && (parampvc.a().mGroupId == localpvc.a().mGroupId))
      {
        localArrayList1.add(localsoh);
        localArrayList2.add(localpvc);
      }
      i += 1;
    }
    paramsoh = new pzd(this, paramsoh, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = 0;
    if (paramInt < localArrayList1.size())
    {
      parampvc = (Animation)((soh)localArrayList1.get(paramInt)).a().getTag(2131369487);
      if (paramInt != 0) {
        parampvc.setAnimationListener(null);
      }
      for (;;)
      {
        ((soh)localArrayList1.get(paramInt)).a().startAnimation(parampvc);
        paramInt += 1;
        break;
        parampvc.setAnimationListener(paramsoh);
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
        this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
        this.jdField_a_of_type_Soh.c.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Soh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (!paramBoolean) {
          break label205;
        }
        i = 8;
        ((KandianUrlImageView)localObject1).setVisibility(i);
        this.jdField_a_of_type_Soh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
        localObject1 = this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView;
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
      this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 0);
      break;
      this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      break;
      i = 0;
      break label90;
    }
    label217:
    Object localObject1 = this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {
      if (a(paramArticleInfo).size() == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(i);
      this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramArticleInfo = this.jdField_a_of_type_Soh.jdField_b_of_type_AndroidWidgetTextView;
      i = k;
      if (paramBoolean) {
        i = 0;
      }
      paramArticleInfo.setVisibility(i);
      this.jdField_a_of_type_Soh.d.setVisibility(0);
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
  
  public void a(soh paramsoh, pvc parampvc)
  {
    paramsoh = parampvc.a();
    parampvc = a(paramsoh);
    int i = 0;
    if (i < Math.min(4, parampvc.size()))
    {
      if (pay.a()) {
        this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageDrawable(bbgk.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, String.valueOf(parampvc.get(i)), 1));
      }
      for (;;)
      {
        String str = String.valueOf(parampvc.get(i));
        this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setOnClickListener(new pzc(this, str, paramsoh));
        i += 1;
        break;
        this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(this.jdField_a_of_type_Slt.a(((Long)parampvc.get(i)).longValue()));
      }
    }
    i = Math.min(4, parampvc.size());
    while (i < 4)
    {
      this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setVisibility(8);
      i += 1;
    }
  }
  
  public void a(soh paramsoh, pvc parampvc, int paramInt)
  {
    this.jdField_a_of_type_Soh = paramsoh;
    this.jdField_a_of_type_Pvc = parampvc;
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pvc.a();
    if (this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_Soh.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Pvc.a()) {
        break label179;
      }
    }
    label179:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      if (this.jdField_a_of_type_Pvc.a())
      {
        this.jdField_a_of_type_Soh.a();
        if (this.jdField_a_of_type_Pvc.c() != 3) {
          break;
        }
        this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Soh.f.setVisibility(8);
        if (this.jdField_a_of_type_Soh.g != null) {
          this.jdField_a_of_type_Soh.g.setVisibility(8);
        }
        this.jdField_a_of_type_Soh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(0);
        this.jdField_a_of_type_Soh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setLogic(this.jdField_a_of_type_Slt, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
        this.jdField_a_of_type_Soh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(parampvc);
      }
      return;
    }
    this.jdField_a_of_type_Soh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.setVisibility(8);
    this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidViewView.setVisibility(0);
    switch (this.jdField_a_of_type_Pvc.c())
    {
    default: 
      this.jdField_a_of_type_Soh.d.setOnClickListener(new pza(this, parampvc, paramsoh));
      return;
    case 1: 
      this.jdField_a_of_type_Boolean = false;
      a(false, localArticleInfo);
      localObject = a(localArticleInfo);
      if (localObject == null)
      {
        this.jdField_a_of_type_Soh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_Soh.c.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidWidgetTextView.setText(a(localArticleInfo));
        break;
        pai.a(this.jdField_a_of_type_Soh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (URL)localObject, this.jdField_a_of_type_AndroidContentContext);
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(true, localArticleInfo);
    a(paramsoh, parampvc);
    Object localObject = a(localArticleInfo);
    if (((List)localObject).size() == 1) {
      if (!pay.a()) {
        break label447;
      }
    }
    label447:
    for (localObject = ContactUtils.getFriendDisplayName((QQAppInterface)pay.a(), String.valueOf(((List)localObject).get(0)));; localObject = this.jdField_a_of_type_Slt.a(((Long)((List)localObject).get(0)).longValue()))
    {
      this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidWidgetTextView.setText(pay.e((String)localObject));
      this.jdField_a_of_type_Soh.jdField_b_of_type_AndroidWidgetTextView.setText(c(localArticleInfo));
      break;
    }
  }
  
  public void a(soh paramsoh, pvc parampvc, long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Pvc.c() == 3) {
      this.jdField_a_of_type_Soh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(paramLong, paramBitmap);
    }
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Soh.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Pvc.c() != 2) || (!pay.a()));
      paramsoh = a(parampvc.a());
    } while ((paramsoh.size() <= 0) || (!paramsoh.contains(Long.valueOf(paramLong))));
    int i = paramsoh.indexOf(Long.valueOf(paramLong));
    this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      a(pay.d(this.jdField_a_of_type_Pvc.a()));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = a(this.jdField_a_of_type_Pvc.a());
        if ((localObject != null) && (((List)localObject).size() == 1))
        {
          localObject = paa.g + bfuc.encodeToString(String.valueOf(((List)localObject).get(0)).getBytes(), 2);
          pay.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
        }
      }
      else
      {
        localObject = b(this.jdField_a_of_type_Pvc.a());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          pay.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
          continue;
          if (!this.jdField_a_of_type_Boolean)
          {
            localObject = b(this.jdField_a_of_type_Pvc.a());
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              pay.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
            }
          }
          else
          {
            localObject = a(this.jdField_a_of_type_Pvc.a());
            if (!((List)localObject).isEmpty())
            {
              localObject = paa.g + bfuc.encodeToString(String.valueOf(((List)localObject).get(0)).getBytes(), 2);
              pay.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyz
 * JD-Core Version:    0.7.0.1
 */