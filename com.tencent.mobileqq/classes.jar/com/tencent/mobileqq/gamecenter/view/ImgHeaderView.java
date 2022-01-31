package com.tencent.mobileqq.gamecenter.view;

import aahi;
import akwd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import asnl;
import asnm;
import asnu;
import asnv;
import asnw;
import asnx;
import asny;
import azus;
import azut;
import azwv;
import bdug;
import bkjb;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import swh;

public class ImgHeaderView
  extends RelativeLayout
  implements asnu
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  
  public ImgHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Activity paramActivity, MessageRecord paramMessageRecord)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    paramActivity.startActivity(localIntent);
    aahi.a(akwd.a(), "769", "205019", asnl.a(paramMessageRecord, 0), "76901", "1", "160", new String[] { asnl.a(paramMessageRecord), "", "20" });
    ((bdug)akwd.a().getBusinessHandler(71)).a(3, paramMessageRecord.getExtInfoFromExtStr("pa_msgId"), this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, QQGameMsgInfo paramQQGameMsgInfo)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    paramActivity.startActivity(localIntent);
    paramActivity = new HashMap();
    paramActivity.put(Integer.valueOf(24), "1");
    paramActivity.put(Integer.valueOf(1), paramString1);
    paramActivity.put(Integer.valueOf(3), "20");
    aahi.a(akwd.a(), "769", "205019", paramString2, "76901", "1", "160", paramActivity);
    bkjb.a(3, paramString1, this.jdField_a_of_type_JavaLangString);
    try
    {
      asnm.a(102, paramQQGameMsgInfo, paramInt);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    Object localObject1 = "";
    Object localObject3;
    for (Object localObject2 = "";; localObject2 = localObject3)
    {
      int k;
      Object localObject5;
      for (;;)
      {
        int n;
        try
        {
          if ((paramMessageRecord instanceof MessageForStructing))
          {
            ArrayList localArrayList = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
            k = 0;
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (k < localArrayList.size())
            {
              localObject3 = localObject2;
              localObject5 = localObject1;
              if (!(localArrayList.get(k) instanceof azut)) {
                break;
              }
              localObject4 = ((azut)localArrayList.get(k)).a;
              m = 0;
              j = 0;
              i = 0;
              if (m >= ((ArrayList)localObject4).size()) {
                break label585;
              }
              if ((((ArrayList)localObject4).get(m) instanceof StructMsgItemTitle))
              {
                localObject2 = ((StructMsgItemTitle)((ArrayList)localObject4).get(m)).Y;
                i = j;
                j = 1;
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
                break label606;
                this.jdField_a_of_type_JavaLangString = ((azus)localArrayList.get(k)).b;
                localObject3 = localObject1;
                localObject5 = localObject4;
                if (j == 0) {
                  break;
                }
                localObject3 = localObject1;
                localObject5 = localObject4;
                if (i == 0) {
                  break;
                }
                localObject3 = localObject1;
              }
            }
            else
            {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559130, this, false));
              this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368092));
              localObject1 = URLDrawable.getDrawable((String)localObject4);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377606));
              this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
              ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370086)).setImageDrawable(URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412124557_I8OGtzphYZ.png"));
              this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365141));
              this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(asnl.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
              this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new asnv(this, paramActivity, paramMessageRecord));
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new asnw(this, paramActivity, paramMessageRecord));
              addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
              return;
            }
            if ((((ArrayList)localObject4).get(m) instanceof azwv))
            {
              localObject3 = ((azwv)((ArrayList)localObject4).get(m)).S;
              n = 1;
              j = i;
              localObject1 = localObject2;
              localObject2 = localObject3;
              i = n;
              break label606;
            }
          }
          else
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (!(paramMessageRecord instanceof MessageForPubAccount)) {
              continue;
            }
            localObject1 = (MessageForPubAccount)paramMessageRecord;
            ((MessageForPubAccount)localObject1).mPAMessage = swh.a(((MessageForPubAccount)localObject1).msgData);
            localObject4 = ((PAMessage.Item)((MessageForPubAccount)localObject1).mPAMessage.items.get(0)).cover;
            localObject3 = ((PAMessage.Item)((MessageForPubAccount)localObject1).mPAMessage.items.get(0)).title;
            this.jdField_a_of_type_JavaLangString = ((PAMessage.Item)((MessageForPubAccount)localObject1).mPAMessage.items.get(0)).url;
            continue;
          }
          n = i;
        }
        catch (Throwable paramMessageRecord)
        {
          QLog.e("ImgHeaderView", 1, "init imgHeader failed e=" + paramMessageRecord.toString());
          return;
        }
        localObject3 = localObject1;
        int i = j;
        int j = n;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label606;
        label585:
        Object localObject4 = localObject1;
        int m = i;
        localObject1 = localObject2;
        i = j;
        j = m;
        continue;
        label606:
        if ((j != 0) && (i != 0))
        {
          localObject4 = localObject2;
        }
        else
        {
          n = m + 1;
          localObject3 = localObject2;
          m = j;
          j = i;
          i = m;
          localObject2 = localObject1;
          localObject1 = localObject3;
          m = n;
        }
      }
      k += 1;
      localObject1 = localObject5;
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    try
    {
      Object localObject = paramQQGameMsgInfo.coverUrl;
      String str = paramQQGameMsgInfo.title;
      this.jdField_a_of_type_JavaLangString = paramQQGameMsgInfo.url;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559130, this, false));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368092));
      localObject = URLDrawable.getDrawable((String)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377606));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370086)).setImageDrawable(URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412124557_I8OGtzphYZ.png"));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365141));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(asnl.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new asnx(this, paramActivity, paramQQGameMsgInfo, paramInt));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new asny(this, paramActivity, paramQQGameMsgInfo, paramInt));
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    catch (Throwable paramQQGameMsgInfo)
    {
      QLog.e("ImgHeaderView", 1, "init imgHeader failed e=" + paramQQGameMsgInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ImgHeaderView
 * JD-Core Version:    0.7.0.1
 */