import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.view.MsgNodeShotView;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.3;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class suo
  implements IEventReceiver, ssy
{
  public QQAppInterface a;
  protected List<Subscriber> a;
  private final sgc jdField_a_of_type_Sgc = new sup(this);
  protected ssr a;
  stw jdField_a_of_type_Stw;
  public sun a;
  public svc a;
  boolean jdField_a_of_type_Boolean = false;
  protected boolean b;
  
  public suo(svc paramsvc, sun paramsun, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Svc = paramsvc;
    this.jdField_a_of_type_Sun = paramsun;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private StoryVideoItem a(ssm paramssm, @NonNull String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramssm.jdField_a_of_type_JavaUtilList.size());
    localArrayList.addAll(paramssm.jdField_a_of_type_JavaUtilList);
    int i = 0;
    String str;
    Object localObject;
    if (i < localArrayList.size()) {
      if (TextUtils.equals(((ste)localArrayList.get(i)).jdField_a_of_type_JavaLangString, paramString))
      {
        if (i + 1 >= localArrayList.size()) {
          break label244;
        }
        str = ((ste)localArrayList.get(i + 1)).jdField_a_of_type_JavaLangString;
        localObject = ((ste)localArrayList.get(i + 1)).b;
      }
    }
    for (;;)
    {
      sqd localsqd = (sqd)sqg.a(5);
      StoryVideoItem localStoryVideoItem;
      if (str != null)
      {
        localStoryVideoItem = localsqd.a(str);
        if (localStoryVideoItem != null)
        {
          urk.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramssm.jdField_a_of_type_JavaLangString, str);
          localStoryVideoItem.mAttachedFeedId = ((String)localObject);
          return localStoryVideoItem;
          i += 1;
          break;
        }
      }
      for (localObject = localStoryVideoItem;; localObject = null)
      {
        if (i != -1)
        {
          while (i > 0)
          {
            localObject = localsqd.a(((ste)localArrayList.get(i)).jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              urk.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramssm.jdField_a_of_type_JavaLangString, paramString);
              return localObject;
            }
            i -= 1;
          }
          return localObject;
        }
        return localObject;
      }
      label244:
      localObject = null;
      str = null;
      continue;
      i = -1;
      localObject = null;
      str = null;
    }
  }
  
  private void a(tjs paramtjs, String paramString)
  {
    urk.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s", paramtjs, paramString);
    if (!(paramtjs instanceof tkg)) {}
    ssm localssm;
    do
    {
      return;
      localssm = ((stf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a(((tkg)paramtjs).a());
      if (localssm == null)
      {
        urk.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s, nodeInfo is null! return!", new Object[] { paramtjs, paramString });
        return;
      }
    } while ((localssm.jdField_a_of_type_Int != 12) || (!(paramtjs instanceof tkg)));
    Bosses.get().postJob(new sur(this, "Q.qqstory.msgTab.MsgTabStoryNodeDelegate", localssm, paramString));
  }
  
  private void b(List<ssm> paramList)
  {
    if ((this.jdField_a_of_type_Sun != null) && (paramList != null))
    {
      this.jdField_a_of_type_Sun.a(paramList);
      a(paramList);
    }
  }
  
  private void b(ssm paramssm, int paramInt)
  {
    List localList;
    if ((this.jdField_a_of_type_Sun != null) && (paramssm != null))
    {
      urk.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, changedData:%s, insertPosition:%s, AdapterList:%s, headerView:%s", paramssm, Integer.valueOf(paramInt), this.jdField_a_of_type_Sun.a(), Integer.valueOf(this.jdField_a_of_type_Sun.b()));
      localList = this.jdField_a_of_type_Sun.a();
      if (localList == null) {
        break label90;
      }
    }
    label90:
    for (int i = localList.size(); (paramInt < 0) || (paramInt >= i); i = 0)
    {
      urk.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, insertPosition illegal, list size = %s", new Object[] { Integer.valueOf(i) });
      return;
    }
    this.jdField_a_of_type_Sun.a(paramssm, paramInt);
  }
  
  private void c(List<ssm> paramList)
  {
    if ((this.jdField_a_of_type_Sun != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_Sun.b(paramList);
      a(paramList);
    }
  }
  
  private void c(ssm paramssm)
  {
    if ((this.jdField_a_of_type_Sun != null) && (paramssm != null)) {
      this.jdField_a_of_type_Sun.a(paramssm);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Svc.jdField_a_of_type_Sun.notifyDataSetChanged();
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Ssr != null)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Ssr.a()).iterator();
      while (localIterator.hasNext())
      {
        ssm localssm = (ssm)localIterator.next();
        if ((localssm != null) && (localssm.jdField_a_of_type_Int == paramInt)) {
          a(localssm);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = this.b;
    if (bool) {
      c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (bool) {
      b();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int i9 = 0;
    int i8 = 0;
    int i7 = 0;
    int i6 = 0;
    int i5 = 0;
    int i4 = 0;
    int i3 = 1;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    int i10 = 0;
    int k = 0;
    int i = 0;
    long l1 = 0L;
    String str = "";
    StringBuilder localStringBuilder = new StringBuilder("{");
    int j = 2;
    int i25 = this.jdField_a_of_type_Sun.getItemCount();
    int i23 = 0;
    ssm localssm;
    if (i23 < i25)
    {
      localssm = (ssm)this.jdField_a_of_type_Sun.a(i23);
      if (localssm != null) {}
    }
    for (;;)
    {
      i23 += 1;
      break;
      int i21;
      int i20;
      int i19;
      int i18;
      int i17;
      int i16;
      int i15;
      int i14;
      int i13;
      int i12;
      int i11;
      int i22;
      long l2;
      switch (localssm.jdField_a_of_type_Int)
      {
      default: 
        i21 = i9;
        i20 = i8;
        i19 = i7;
        i18 = i6;
        i17 = i5;
        i16 = i4;
        i15 = i3;
        i14 = i2;
        i13 = i1;
        i12 = n;
        i11 = m;
        i22 = k;
        l2 = l1;
      }
      Object localObject;
      for (;;)
      {
        if (localssm.b != 0) {
          j = 1;
        }
        if (!localssm.c) {
          break label1519;
        }
        i += 1;
        l1 = l2;
        k = i22;
        m = i11;
        n = i12;
        i1 = i13;
        i2 = i14;
        i3 = i15;
        i4 = i16;
        i5 = i17;
        i6 = i18;
        i7 = i19;
        i8 = i20;
        i9 = i21;
        break;
        i21 = i9 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        continue;
        i20 = i8 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i21 = i9;
        continue;
        i19 = i7 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i20 = i8;
        i21 = i9;
        continue;
        i18 = i6 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i17 = i5 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i16 = i4 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i15 = i3 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i14 = i2 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i13 = i1 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i12 = n + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i11 = m + 1;
        if (localssm.d > 0) {}
        for (localObject = "2";; localObject = "1")
        {
          localStringBuilder.append("\"mystory\":").append((String)localObject);
          l2 = l1;
          i22 = k;
          i12 = n;
          i13 = i1;
          i14 = i2;
          i15 = i3;
          i16 = i4;
          i17 = i5;
          i18 = i6;
          i19 = i7;
          i20 = i8;
          i21 = i9;
          break;
        }
        int i24 = i10 + 1;
        l2 = l1;
        i22 = k;
        i10 = i24;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        if (l1 == 0L)
        {
          str = localssm.jdField_e_of_type_JavaLangString;
          l2 = localssm.a(str);
          i22 = k;
          i10 = i24;
          i11 = m;
          i12 = n;
          i13 = i1;
          i14 = i2;
          i15 = i3;
          i16 = i4;
          i17 = i5;
          i18 = i6;
          i19 = i7;
          i20 = i8;
          i21 = i9;
          continue;
          i22 = k + 1;
          l2 = l1;
          i11 = m;
          i12 = n;
          i13 = i1;
          i14 = i2;
          i15 = i3;
          i16 = i4;
          i17 = i5;
          i18 = i6;
          i19 = i7;
          i20 = i8;
          i21 = i9;
        }
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put(String.valueOf(6), i9);
        ((JSONObject)localObject).put(String.valueOf(7), i8);
        ((JSONObject)localObject).put(String.valueOf(8), i7);
        ((JSONObject)localObject).put(String.valueOf(9), i6);
        ((JSONObject)localObject).put(String.valueOf(11), i5);
        ((JSONObject)localObject).put(String.valueOf(10), i4);
        ((JSONObject)localObject).put(String.valueOf(1), i3);
        ((JSONObject)localObject).put(String.valueOf(2), i2);
        ((JSONObject)localObject).put(String.valueOf(3), i1);
        ((JSONObject)localObject).put(String.valueOf(4), n);
        ((JSONObject)localObject).put(String.valueOf(5), m);
        ((JSONObject)localObject).put(String.valueOf(12), i10 + ":" + str + ":" + l1);
        ((JSONObject)localObject).put(String.valueOf(13), k);
        if (TextUtils.equals("exp_story", paramString))
        {
          localStringBuilder.append(",\"text\":").append("\"").append(this.jdField_a_of_type_Svc.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a()).append("\"");
          localStringBuilder.append(",\"msg\":").append(i);
        }
        localStringBuilder.append("}");
        urp.a("msg_tab", paramString, 0, j, new String[] { ((JSONObject)localObject).toString(), String.valueOf(i25), localStringBuilder.toString(), String.valueOf(paramInt) });
        return;
      }
      catch (JSONException paramString)
      {
        urk.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "ReportError:" + paramString.getMessage());
        return;
      }
      label1519:
      l1 = l2;
      k = i22;
      m = i11;
      n = i12;
      i1 = i13;
      i2 = i14;
      i3 = i15;
      i4 = i16;
      i5 = i17;
      i6 = i18;
      i7 = i19;
      i8 = i20;
      i9 = i21;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    int i = this.jdField_a_of_type_Sun.a(paramString1);
    this.jdField_a_of_type_Svc.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.scrollToPosition(i);
    if (!suk.a()) {
      return;
    }
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeDelegate.3(this, paramString1));
  }
  
  public void a(ArrayList<ssm> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    urk.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onDataSetChange() %s, %b, %b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3));
    if (paramBoolean1)
    {
      b(paramArrayList);
      if (this.jdField_a_of_type_Svc.jdField_a_of_type_Long != 0L)
      {
        urp.b("msgtab", "data_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Svc.jdField_a_of_type_Long), 0, new String[] { "" });
        this.jdField_a_of_type_Svc.jdField_a_of_type_Long = 0L;
      }
    }
    while ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ssm localssm = (ssm)localIterator.next();
          if ((localssm.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(localssm.jdField_a_of_type_JavaLangString)))
          {
            localArrayList.add(localssm.jdField_a_of_type_JavaLangString);
            continue;
            c(paramArrayList);
            break;
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        new sxa(localArrayList, String.valueOf(System.currentTimeMillis())).a();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "dataSetChange dataList = ", paramArrayList });
    }
  }
  
  public void a(List<ssm> paramList)
  {
    Context localContext = this.jdField_a_of_type_Svc.jdField_a_of_type_AndroidContentContext;
    if ((!paramList.isEmpty()) && (this.jdField_a_of_type_Stw != null)) {
      this.jdField_a_of_type_Stw.a(localContext, paramList);
    }
  }
  
  public void a(ssm paramssm)
  {
    if ((this.jdField_a_of_type_Sun != null) && (paramssm != null)) {
      this.jdField_a_of_type_Sun.a(paramssm);
    }
  }
  
  public void a(ssm paramssm, int paramInt)
  {
    QQUserUIItem localQQUserUIItem = ((sqs)sqg.a(2)).b(paramssm.jdField_a_of_type_JavaLangString);
    if (localQQUserUIItem == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "SUBSCRIBE failed: user is null, unionId = " + paramssm.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    paramssm = (sfz)tfy.a().a(98);
    if (localQQUserUIItem.isVip()) {}
    for (int i = 1;; i = 0)
    {
      paramssm.a(i, localQQUserUIItem.uid, paramInt, 14);
      return;
    }
  }
  
  public void a(ssm paramssm, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((paramBoolean1) && (paramssm != null) && (paramssm.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(paramssm.jdField_a_of_type_JavaLangString))) {
        new sxa(paramssm.jdField_a_of_type_JavaLangString, String.valueOf(System.currentTimeMillis())).a();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "singleDataChange, data=" + paramssm + ", type=" + paramInt1);
      }
      return;
      b(paramssm, paramInt2);
      a(Collections.singletonList(paramssm));
      if ((paramBoolean1) && (paramBoolean2))
      {
        urk.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_INSERT_OR_REPLACE");
        this.jdField_a_of_type_Svc.h();
        continue;
        a(paramssm);
        a(Collections.singletonList(paramssm));
        if ((paramBoolean1) && (paramBoolean2))
        {
          urk.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_UPDATE");
          this.jdField_a_of_type_Svc.h();
          continue;
          c(paramssm);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    Object localObject = (stf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    this.jdField_a_of_type_Ssr = ((stf)localObject).a();
    this.jdField_a_of_type_Stw = ((stf)localObject).a();
    b(this.jdField_a_of_type_Ssr.b());
    this.jdField_a_of_type_Ssr.a(this);
    this.jdField_a_of_type_Ssr.a(1);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new sux(this));
    this.jdField_a_of_type_JavaUtilList.add(new sus(this));
    this.jdField_a_of_type_JavaUtilList.add(new suv(this));
    this.jdField_a_of_type_JavaUtilList.add(new svb(this));
    this.jdField_a_of_type_JavaUtilList.add(new sut(this));
    this.jdField_a_of_type_JavaUtilList.add(new suu(this));
    this.jdField_a_of_type_JavaUtilList.add(new suw(this));
    this.jdField_a_of_type_JavaUtilList.add(new suz(this));
    this.jdField_a_of_type_JavaUtilList.add(new sva(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Sgc);
    this.jdField_a_of_type_Stw.a(new suq(this));
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Iterator)localObject).next();
      sgi.a().registerSubscriber("", localSubscriber);
    }
    this.b = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onAttached");
    }
  }
  
  public void b(ssm paramssm)
  {
    sfz localsfz = (sfz)tfy.a().a(98);
    String str = paramssm.jdField_a_of_type_JavaLangString;
    if ((paramssm.jdField_a_of_type_Int == 10) || (paramssm.jdField_a_of_type_Int == 11)) {
      str = null;
    }
    localsfz.a(str, paramssm.jdField_a_of_type_Int, 1, paramssm.jdField_e_of_type_Long);
    this.jdField_a_of_type_Ssr.b(paramssm);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onDetached");
      }
      this.b = false;
      if (this.jdField_a_of_type_Ssr != null) {
        this.jdField_a_of_type_Ssr.b(this);
      }
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          Subscriber localSubscriber = (Subscriber)localIterator.next();
          sgi.a().unRegisterSubscriber(localSubscriber);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Sgc);
    if (this.jdField_a_of_type_Stw != null) {
      this.jdField_a_of_type_Stw.a();
    }
    this.jdField_a_of_type_Sun.a();
  }
  
  public void d() {}
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suo
 * JD-Core Version:    0.7.0.1
 */