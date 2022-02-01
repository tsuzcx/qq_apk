package com.tencent.tkd.topicsdk.publisharticle.draft;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/draft/DraftManager$Companion;", "", "()V", "instance", "Lcom/tencent/tkd/topicsdk/publisharticle/draft/DraftManager;", "get", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DraftManager$Companion
{
  @JvmStatic
  @NotNull
  public final DraftManager a()
  {
    DraftManager localDraftManager = DraftManager.a();
    if (localDraftManager != null) {
      return localDraftManager;
    }
    try
    {
      localDraftManager = new DraftManager(null);
      DraftManager.a(localDraftManager);
      return localDraftManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.draft.DraftManager.Companion
 * JD-Core Version:    0.7.0.1
 */