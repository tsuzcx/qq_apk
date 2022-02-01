package com.tencent.mobileqq.studymode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.io.Serializable;

abstract interface KidModeServlet$ResponseHandler
  extends Serializable
{
  public abstract void handle(KidModeServlet paramKidModeServlet, Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.ResponseHandler
 * JD-Core Version:    0.7.0.1
 */