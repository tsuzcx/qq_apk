package com.tencent.mobileqq.gamecenter.gameroom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class GameQuickWordsPanel
  extends RelativeLayout
{
  public String a;
  public WerewolvesPluginManager b;
  ArrayList<String> c;
  XListView d = null;
  SessionInfo e;
  QQAppInterface f;
  GameRoomChatPie g;
  
  public GameQuickWordsPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    ((GameQuickWordsPanel.WordsAdapter)this.d.getAdapter()).notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, GameRoomChatPie paramGameRoomChatPie)
  {
    this.f = paramQQAppInterface;
    this.e = paramSessionInfo;
    this.a = paramSessionInfo.b;
    this.g = paramGameRoomChatPie;
    this.b = ((WerewolvesHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(this.a);
    paramQQAppInterface = this.b.c();
    if (paramQQAppInterface != null) {
      paramQQAppInterface = paramQQAppInterface.h();
    } else {
      paramQQAppInterface = null;
    }
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0))
    {
      this.c = paramQQAppInterface;
    }
    else
    {
      this.c = new ArrayList();
      this.c.add(HardCodeUtil.a(2131903046));
      this.c.add(HardCodeUtil.a(2131903047));
      this.c.add(HardCodeUtil.a(2131903050));
      this.c.add(HardCodeUtil.a(2131903049));
      this.c.add(HardCodeUtil.a(2131903048));
    }
    this.d = ((XListView)findViewById(2131434021));
    this.d.setOnItemClickListener(new GameQuickWordsPanel.1(this));
    paramQQAppInterface = new GameQuickWordsPanel.WordsAdapter(this);
    this.d.setAdapter(paramQQAppInterface);
    paramQQAppInterface.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */