package com.tencent.timi.game.team.impl.chat;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.ui.utils.ResUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/team/impl/chat/TeamInputView;", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiIv", "Landroid/widget/ImageView;", "inputEt", "Landroid/widget/EditText;", "sendBtn", "Landroid/view/View;", "getEmojiBtn", "getInputEditText", "getLayoutId", "getSendBtn", "layoutInflated", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamInputView
  extends TimiBaseInputView
{
  private View a;
  private EditText c;
  private ImageView d;
  
  @JvmOverloads
  public TeamInputView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TeamInputView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TeamInputView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    this.a = findViewById(2131445618);
    this.c = ((EditText)findViewById(2131435831));
    this.d = ((ImageView)findViewById(2131432439));
    Object localObject = this.c;
    if (localObject != null) {
      ((EditText)localObject).addTextChangedListener((TextWatcher)new TeamInputView.layoutInflated.1(this));
    }
    localObject = this.c;
    if (localObject != null) {
      ((EditText)localObject).post((Runnable)new TeamInputView.layoutInflated.2(this));
    }
    localObject = this.d;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new TeamInputView.layoutInflated.3(this));
    }
    localObject = ResUtils.c(2131917691);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ResUtils.getString(R.string.try_send_something)");
    TimiBaseInputView.a(this, 0.0F, 0, (String)localObject, 3, null);
    a((TimiBaseInputView.StateChangedListener)new TeamInputView.layoutInflated.4(this));
  }
  
  @Nullable
  public ImageView getEmojiBtn()
  {
    return this.d;
  }
  
  @Nullable
  public EditText getInputEditText()
  {
    return this.c;
  }
  
  public int getLayoutId()
  {
    return 2131629494;
  }
  
  @Nullable
  public View getSendBtn()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamInputView
 * JD-Core Version:    0.7.0.1
 */