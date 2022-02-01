package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;

class NewStyleDropdownView$AutoCompleteView
  extends AutoCompleteTextView
{
  private boolean b;
  
  public NewStyleDropdownView$AutoCompleteView(NewStyleDropdownView paramNewStyleDropdownView, Context paramContext)
  {
    super(paramContext);
    setId(526);
    this.b = true;
  }
  
  public NewStyleDropdownView$AutoCompleteView(NewStyleDropdownView paramNewStyleDropdownView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setId(526);
    this.b = true;
  }
  
  public NewStyleDropdownView$AutoCompleteView(NewStyleDropdownView paramNewStyleDropdownView, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setId(526);
    this.b = true;
  }
  
  public boolean enoughToFilter()
  {
    return true;
  }
  
  public boolean isPopupShowing()
  {
    if (this.b) {
      return super.isPopupShowing();
    }
    return false;
  }
  
  public void onEditorAction(int paramInt)
  {
    if (paramInt == 5)
    {
      View localView = focusSearch(130);
      if (localView != null)
      {
        if (localView.requestFocus(130)) {
          return;
        }
        throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
      }
      return;
    }
    super.onEditorAction(paramInt);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    try
    {
      if (isPopupShowing()) {
        dismissDropDown();
      }
      return;
    }
    catch (Exception paramCharSequence) {}
  }
  
  protected void performFiltering(CharSequence paramCharSequence, int paramInt) {}
  
  /* Error */
  public void showDropDown()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 75	android/widget/AutoCompleteTextView:showDropDown	()V
    //   4: getstatic 81	android/os/Build$VERSION:SDK_INT	I
    //   7: bipush 8
    //   9: if_icmpgt +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   17: invokevirtual 92	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   20: ldc 94
    //   22: invokevirtual 98	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   25: astore 7
    //   27: aload 7
    //   29: iconst_1
    //   30: invokevirtual 104	java/lang/reflect/Field:setAccessible	(Z)V
    //   33: aload 7
    //   35: aload_0
    //   36: invokevirtual 108	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: astore 7
    //   41: aload 7
    //   43: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   46: invokevirtual 92	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   49: ldc 110
    //   51: iconst_1
    //   52: anewarray 89	java/lang/Class
    //   55: dup
    //   56: iconst_0
    //   57: getstatic 116	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   60: aastore
    //   61: invokevirtual 120	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   64: aload 7
    //   66: iconst_1
    //   67: anewarray 83	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: iconst_0
    //   73: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: aload 7
    //   83: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   86: invokevirtual 92	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   89: ldc 132
    //   91: iconst_1
    //   92: anewarray 89	java/lang/Class
    //   95: dup
    //   96: iconst_0
    //   97: getstatic 135	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   100: aastore
    //   101: invokevirtual 120	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   104: aload 7
    //   106: iconst_1
    //   107: anewarray 83	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: iconst_0
    //   113: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   116: aastore
    //   117: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: return
    //   122: aload_0
    //   123: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   126: invokevirtual 92	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   129: ldc 140
    //   131: invokevirtual 98	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   134: astore 7
    //   136: aload 7
    //   138: iconst_1
    //   139: invokevirtual 104	java/lang/reflect/Field:setAccessible	(Z)V
    //   142: aload 7
    //   144: aload_0
    //   145: invokevirtual 108	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: astore 7
    //   150: aload 7
    //   152: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   155: ldc 94
    //   157: invokevirtual 98	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   160: astore 8
    //   162: aload 8
    //   164: iconst_1
    //   165: invokevirtual 104	java/lang/reflect/Field:setAccessible	(Z)V
    //   168: aload 8
    //   170: aload 7
    //   172: invokevirtual 108	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   175: astore 8
    //   177: aload 8
    //   179: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   182: invokevirtual 92	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   185: ldc 110
    //   187: iconst_1
    //   188: anewarray 89	java/lang/Class
    //   191: dup
    //   192: iconst_0
    //   193: getstatic 116	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   196: aastore
    //   197: invokevirtual 120	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   200: aload 8
    //   202: iconst_1
    //   203: anewarray 83	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iconst_0
    //   209: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   216: pop
    //   217: aload 8
    //   219: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   222: invokevirtual 92	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   225: ldc 132
    //   227: iconst_1
    //   228: anewarray 89	java/lang/Class
    //   231: dup
    //   232: iconst_0
    //   233: getstatic 135	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   236: aastore
    //   237: invokevirtual 120	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   240: aload 8
    //   242: iconst_1
    //   243: anewarray 83	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: iconst_0
    //   249: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   252: aastore
    //   253: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   256: pop
    //   257: aload 7
    //   259: instanceof 142
    //   262: ifeq +13 -> 275
    //   265: aload 7
    //   267: checkcast 142	android/widget/PopupWindow
    //   270: ldc 143
    //   272: invokevirtual 146	android/widget/PopupWindow:setAnimationStyle	(I)V
    //   275: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +39 -> 317
    //   281: new 153	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   288: astore 8
    //   290: aload 8
    //   292: ldc 157
    //   294: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 8
    //   300: aload 7
    //   302: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: ldc 166
    //   308: iconst_2
    //   309: aload 8
    //   311: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload 7
    //   319: instanceof 176
    //   322: ifeq +544 -> 866
    //   325: aload 7
    //   327: checkcast 176	android/widget/ListPopupWindow
    //   330: astore 7
    //   332: aload 7
    //   334: invokevirtual 180	android/widget/ListPopupWindow:getListView	()Landroid/widget/ListView;
    //   337: ifnull +529 -> 866
    //   340: aload 7
    //   342: invokevirtual 180	android/widget/ListPopupWindow:getListView	()Landroid/widget/ListView;
    //   345: astore 7
    //   347: aload 7
    //   349: aload_0
    //   350: getfield 12	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:a	Lcom/tencent/mobileqq/widget/NewStyleDropdownView;
    //   353: ldc 181
    //   355: aload_0
    //   356: invokevirtual 185	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:getResources	()Landroid/content/res/Resources;
    //   359: invokestatic 190	com/tencent/mobileqq/widget/NewStyleDropdownView:a	(Lcom/tencent/mobileqq/widget/NewStyleDropdownView;FLandroid/content/res/Resources;)I
    //   362: iconst_0
    //   363: aload_0
    //   364: getfield 12	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:a	Lcom/tencent/mobileqq/widget/NewStyleDropdownView;
    //   367: ldc 181
    //   369: aload_0
    //   370: invokevirtual 185	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:getResources	()Landroid/content/res/Resources;
    //   373: invokestatic 190	com/tencent/mobileqq/widget/NewStyleDropdownView:a	(Lcom/tencent/mobileqq/widget/NewStyleDropdownView;FLandroid/content/res/Resources;)I
    //   376: iconst_0
    //   377: invokevirtual 196	android/widget/ListView:setPadding	(IIII)V
    //   380: aload 7
    //   382: iconst_2
    //   383: invokevirtual 199	android/widget/ListView:setOverScrollMode	(I)V
    //   386: aload 7
    //   388: iconst_0
    //   389: invokevirtual 201	android/widget/ListView:setVerticalScrollBarEnabled	(Z)V
    //   392: aload 7
    //   394: aconst_null
    //   395: invokevirtual 205	android/widget/ListView:setDivider	(Landroid/graphics/drawable/Drawable;)V
    //   398: aload 7
    //   400: iconst_0
    //   401: invokevirtual 207	android/widget/ListView:setDividerHeight	(I)V
    //   404: goto +44 -> 448
    //   407: astore 8
    //   409: new 153	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   416: astore 9
    //   418: aload 9
    //   420: ldc 209
    //   422: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 9
    //   428: aload 8
    //   430: invokevirtual 212	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   433: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: ldc 166
    //   439: iconst_1
    //   440: aload 9
    //   442: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: aload 7
    //   450: invokevirtual 219	android/widget/ListView:getParent	()Landroid/view/ViewParent;
    //   453: astore 7
    //   455: aload 7
    //   457: instanceof 221
    //   460: ifeq +406 -> 866
    //   463: aload 7
    //   465: checkcast 221	android/widget/FrameLayout
    //   468: astore 9
    //   470: aload_0
    //   471: invokevirtual 225	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:getAdapter	()Landroid/widget/ListAdapter;
    //   474: invokeinterface 231 1 0
    //   479: istore 4
    //   481: aconst_null
    //   482: astore 7
    //   484: iconst_0
    //   485: istore_1
    //   486: iconst_0
    //   487: istore 5
    //   489: iconst_0
    //   490: istore_2
    //   491: iload_1
    //   492: aload 9
    //   494: invokevirtual 234	android/widget/FrameLayout:getChildCount	()I
    //   497: if_icmpge +108 -> 605
    //   500: aload 9
    //   502: iload_1
    //   503: invokevirtual 237	android/widget/FrameLayout:getChildAt	(I)Landroid/view/View;
    //   506: ifnull +34 -> 540
    //   509: aload 9
    //   511: iload_1
    //   512: invokevirtual 237	android/widget/FrameLayout:getChildAt	(I)Landroid/view/View;
    //   515: instanceof 239
    //   518: ifeq +22 -> 540
    //   521: aload 9
    //   523: iload_1
    //   524: invokevirtual 237	android/widget/FrameLayout:getChildAt	(I)Landroid/view/View;
    //   527: checkcast 239	com/tencent/mobileqq/widget/LoginPopupMaskView
    //   530: astore 8
    //   532: iconst_1
    //   533: istore 6
    //   535: iload_2
    //   536: istore_3
    //   537: goto +343 -> 880
    //   540: iload 5
    //   542: istore 6
    //   544: iload_2
    //   545: istore_3
    //   546: aload 7
    //   548: astore 8
    //   550: aload 9
    //   552: iload_1
    //   553: invokevirtual 237	android/widget/FrameLayout:getChildAt	(I)Landroid/view/View;
    //   556: ifnull +324 -> 880
    //   559: iload 5
    //   561: istore 6
    //   563: iload_2
    //   564: istore_3
    //   565: aload 7
    //   567: astore 8
    //   569: aload 9
    //   571: iload_1
    //   572: invokevirtual 237	android/widget/FrameLayout:getChildAt	(I)Landroid/view/View;
    //   575: instanceof 241
    //   578: ifeq +302 -> 880
    //   581: aload 9
    //   583: iload_1
    //   584: invokevirtual 237	android/widget/FrameLayout:getChildAt	(I)Landroid/view/View;
    //   587: checkcast 241	com/tencent/mobileqq/widget/LoginPopupRightMaskView
    //   590: astore 8
    //   592: iconst_1
    //   593: istore_3
    //   594: iload 5
    //   596: istore 6
    //   598: aload 7
    //   600: astore 8
    //   602: goto +278 -> 880
    //   605: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq +55 -> 663
    //   611: new 153	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   618: astore 8
    //   620: aload 8
    //   622: ldc 243
    //   624: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 8
    //   630: iload 5
    //   632: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload 8
    //   638: ldc 248
    //   640: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 8
    //   646: iload 4
    //   648: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: ldc 166
    //   654: iconst_2
    //   655: aload 8
    //   657: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: iload_2
    //   664: ifne +56 -> 720
    //   667: new 241	com/tencent/mobileqq/widget/LoginPopupRightMaskView
    //   670: dup
    //   671: aload 9
    //   673: invokevirtual 255	android/widget/FrameLayout:getContext	()Landroid/content/Context;
    //   676: invokespecial 256	com/tencent/mobileqq/widget/LoginPopupRightMaskView:<init>	(Landroid/content/Context;)V
    //   679: astore 8
    //   681: new 258	android/widget/FrameLayout$LayoutParams
    //   684: dup
    //   685: aload_0
    //   686: getfield 12	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:a	Lcom/tencent/mobileqq/widget/NewStyleDropdownView;
    //   689: ldc_w 259
    //   692: aload_0
    //   693: invokevirtual 185	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:getResources	()Landroid/content/res/Resources;
    //   696: invokestatic 190	com/tencent/mobileqq/widget/NewStyleDropdownView:a	(Lcom/tencent/mobileqq/widget/NewStyleDropdownView;FLandroid/content/res/Resources;)I
    //   699: iconst_m1
    //   700: invokespecial 262	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   703: astore 10
    //   705: aload 10
    //   707: iconst_5
    //   708: putfield 265	android/widget/FrameLayout$LayoutParams:gravity	I
    //   711: aload 9
    //   713: aload 8
    //   715: aload 10
    //   717: invokevirtual 269	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   720: aload 7
    //   722: ifnull +24 -> 746
    //   725: iload 4
    //   727: iconst_4
    //   728: if_icmple +10 -> 738
    //   731: aload 7
    //   733: iconst_0
    //   734: invokevirtual 272	com/tencent/mobileqq/widget/LoginPopupMaskView:setVisibility	(I)V
    //   737: return
    //   738: aload 7
    //   740: bipush 8
    //   742: invokevirtual 272	com/tencent/mobileqq/widget/LoginPopupMaskView:setVisibility	(I)V
    //   745: return
    //   746: iload 5
    //   748: ifne +118 -> 866
    //   751: iload 4
    //   753: iconst_4
    //   754: if_icmple +112 -> 866
    //   757: new 239	com/tencent/mobileqq/widget/LoginPopupMaskView
    //   760: dup
    //   761: aload 9
    //   763: invokevirtual 255	android/widget/FrameLayout:getContext	()Landroid/content/Context;
    //   766: invokespecial 273	com/tencent/mobileqq/widget/LoginPopupMaskView:<init>	(Landroid/content/Context;)V
    //   769: astore 7
    //   771: new 258	android/widget/FrameLayout$LayoutParams
    //   774: dup
    //   775: iconst_m1
    //   776: aload_0
    //   777: getfield 12	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:a	Lcom/tencent/mobileqq/widget/NewStyleDropdownView;
    //   780: ldc_w 274
    //   783: aload_0
    //   784: invokevirtual 185	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:getResources	()Landroid/content/res/Resources;
    //   787: invokestatic 190	com/tencent/mobileqq/widget/NewStyleDropdownView:a	(Lcom/tencent/mobileqq/widget/NewStyleDropdownView;FLandroid/content/res/Resources;)I
    //   790: invokespecial 262	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   793: astore 8
    //   795: aload 8
    //   797: iconst_0
    //   798: putfield 277	android/widget/FrameLayout$LayoutParams:bottomMargin	I
    //   801: aload 8
    //   803: bipush 80
    //   805: putfield 265	android/widget/FrameLayout$LayoutParams:gravity	I
    //   808: aload 9
    //   810: aload 7
    //   812: aload 8
    //   814: invokevirtual 269	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   817: return
    //   818: astore 7
    //   820: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   823: ifeq +43 -> 866
    //   826: new 153	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   833: astore 8
    //   835: aload 8
    //   837: ldc_w 279
    //   840: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload 8
    //   846: aload 7
    //   848: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   851: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: ldc 166
    //   857: iconst_2
    //   858: aload 8
    //   860: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: return
    //   867: astore 7
    //   869: aload 7
    //   871: invokevirtual 283	java/lang/OutOfMemoryError:printStackTrace	()V
    //   874: return
    //   875: astore 7
    //   877: goto -755 -> 122
    //   880: iload_1
    //   881: iconst_1
    //   882: iadd
    //   883: istore_1
    //   884: iload 6
    //   886: istore 5
    //   888: iload_3
    //   889: istore_2
    //   890: aload 8
    //   892: astore 7
    //   894: goto -403 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	897	0	this	AutoCompleteView
    //   485	399	1	i	int
    //   490	400	2	j	int
    //   536	353	3	k	int
    //   479	276	4	m	int
    //   487	400	5	bool1	boolean
    //   533	352	6	bool2	boolean
    //   25	786	7	localObject1	java.lang.Object
    //   818	29	7	localException1	Exception
    //   867	3	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   875	1	7	localException2	Exception
    //   892	1	7	localObject2	java.lang.Object
    //   160	150	8	localObject3	java.lang.Object
    //   407	22	8	localThrowable	java.lang.Throwable
    //   530	361	8	localObject4	java.lang.Object
    //   416	393	9	localObject5	java.lang.Object
    //   703	13	10	localLayoutParams	android.widget.FrameLayout.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   347	404	407	java/lang/Throwable
    //   122	275	818	java/lang/Exception
    //   275	317	818	java/lang/Exception
    //   317	347	818	java/lang/Exception
    //   347	404	818	java/lang/Exception
    //   409	448	818	java/lang/Exception
    //   448	481	818	java/lang/Exception
    //   491	532	818	java/lang/Exception
    //   550	559	818	java/lang/Exception
    //   569	592	818	java/lang/Exception
    //   605	663	818	java/lang/Exception
    //   667	720	818	java/lang/Exception
    //   731	737	818	java/lang/Exception
    //   738	745	818	java/lang/Exception
    //   757	817	818	java/lang/Exception
    //   0	4	867	java/lang/OutOfMemoryError
    //   13	121	875	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView.AutoCompleteView
 * JD-Core Version:    0.7.0.1
 */