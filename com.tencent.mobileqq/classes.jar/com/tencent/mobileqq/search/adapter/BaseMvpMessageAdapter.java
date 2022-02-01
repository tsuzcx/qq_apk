package com.tencent.mobileqq.search.adapter;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.base.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.base.view.IFaceView;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.MessageSearchResultDetailModel;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMvpMessageAdapter<M extends IFaceModel, V extends IFaceView>
  extends BaseMvpFaceAdapter<M, V>
{
  private int a;
  private int d;
  private int e = 0;
  private List<MessageSearchResultDetailModel> f;
  private FullMessageSearchResult.SearchResultItem g;
  private String h;
  private int i;
  private String j;
  private QQAppInterface k;
  
  public BaseMvpMessageAdapter(ListView paramListView, IFaceDecoder paramIFaceDecoder, FullMessageSearchResult.SearchResultItem paramSearchResultItem, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramListView, paramIFaceDecoder);
    if (paramSearchResultItem != null) {
      try
      {
        this.g = paramSearchResultItem;
        this.h = paramSearchResultItem.user.uin;
        this.i = paramSearchResultItem.user.getType();
      }
      catch (NullPointerException paramListView)
      {
        QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, new Object[] { "BaseMvpMessageAdapter init e:", paramListView.toString() });
      }
    }
    this.j = paramString;
    this.k = paramQQAppInterface;
    this.f = new ArrayList();
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2011)
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramMessageRecord.msgData);
      if ((localAbsStructMsg != null) && ((localAbsStructMsg instanceof AbsShareMsg)))
      {
        AbsShareMsg localAbsShareMsg = (AbsShareMsg)localAbsStructMsg;
        paramMessageRecord.msg = localAbsShareMsg.mContentTitle;
        if ((TextUtils.isEmpty(paramMessageRecord.msg)) && ((localAbsStructMsg instanceof AbsStructMsg))) {
          paramMessageRecord.msg = localAbsShareMsg.mMsgBrief;
        }
      }
    }
  }
  
  private void b()
  {
    if ((this.e - this.d == this.a) && (this.c == 0)) {
      a();
    }
  }
  
  public void a()
  {
    try
    {
      int n = this.f.size();
      int m = n + 50;
      if (m >= this.g.secondPageMessageUniseq.size()) {
        m = this.g.secondPageMessageUniseq.size();
      }
      while (n < m)
      {
        MessageRecord localMessageRecord = this.k.getMessageFacade().b(this.h, this.i, ((Long)this.g.secondPageMessageUniseq.get(n)).longValue());
        if (localMessageRecord != null)
        {
          a(localMessageRecord);
          if (localMessageRecord.msg != null) {
            this.f.add(new MessageSearchResultDetailModel(this.k, this.j, this.g.user, localMessageRecord));
          }
        }
        n += 1;
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, new Object[] { "initData e:", localNullPointerException.toString() });
      super.a(this.f);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt1;
    this.a = paramInt2;
    this.e = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.BaseMvpMessageAdapter
 * JD-Core Version:    0.7.0.1
 */